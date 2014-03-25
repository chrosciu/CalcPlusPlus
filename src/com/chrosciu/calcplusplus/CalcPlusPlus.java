package com.chrosciu.calcplusplus;

public class CalcPlusPlus {
	
	public int add(int a, int b) {
		int rv = a;
		while (b-- > 0) {
			rv++;
		}
		return rv;
	}
	
	public int multiply(int a, int b) {
		int rv = 0;
		while (b-- > 0) {
			rv = add(rv, a);
		}
		return rv;
	}
	
	public int power(int a, int b) {
		int rv = 1;
		while (b-- > 0) {
			rv = multiply(rv, a);
		}
		return rv;
	}

}
