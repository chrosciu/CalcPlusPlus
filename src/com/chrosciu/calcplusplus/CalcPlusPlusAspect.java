package com.chrosciu.calcplusplus;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalcPlusPlusAspect {
	
	@Pointcut("call(public * CalcPlusPlus.*(..))")
	void calcMethodCall() {}
	
	@Pointcut("call(public * CalcPlusPlus.multiply(..))")
	void calcMultiplyCall() {}
	
	@Around("calcMultiplyCall() && args(arg1, arg2)")
	public Object aroundCalcMultiplyCall(ProceedingJoinPoint thisJoinPoint, int arg1, int arg2) throws Throwable {
		boolean reverse = false;
		if (arg1 < 0 && arg2 < 0) {
			arg1 = -arg1;
			arg2 = -arg2;
		} else if (arg1 < 0) {
			arg1 = -arg1;
			reverse = true;
		} else if (arg2 < 0) {
			arg2 = -arg2;
			reverse = true;
		}
		int rv = (Integer)thisJoinPoint.proceed(new Object[] {arg1, arg2});
		if (reverse) {
			rv = -rv;
		}
		return rv;
	}
	
	
	@Around("calcMethodCall() && !cflowbelow(calcMethodCall()) && args(arg1, arg2)")
	public Object aroundCalcMethodCall(ProceedingJoinPoint thisJoinPoint, int arg1, int arg2) throws Throwable {
		validateArgs(arg1, arg2);
		long start = System.nanoTime();
		Object rv = thisJoinPoint.proceed();
		long end = System.nanoTime();
		System.out.println("Call to: " + thisJoinPoint.getSignature().getName() + " took " + (end - start) + " ns");
		return rv;
	}
	
	private void validateArgs(int arg1, int arg2) {
		if (arg1 < 0 || arg2 < 0) {
			throw new IllegalArgumentException("Negative numbers are not accepted!");
		}
	}

}
