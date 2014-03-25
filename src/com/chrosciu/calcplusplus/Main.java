package com.chrosciu.calcplusplus;

public class Main {

	public static void main(String[] args) {
		CalcPlusPlus calc = new CalcPlusPlus();
		
		System.out.println(calc.add(4, 6));
		try {
			System.out.println(calc.add(4, -6));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		System.out.println(calc.multiply(4, 6));
		System.out.println(calc.multiply(4, -6));
		
		System.out.println(calc.power(4, 6));
		try {
			System.out.println(calc.power(4, -6));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}	
	}

}
