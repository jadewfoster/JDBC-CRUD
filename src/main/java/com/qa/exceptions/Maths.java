package com.qa.exceptions;

public class Maths {

	public void divide(int a, int b) throws DivisionRuleException {

		if (a < b) {
			throw new DivisionRuleException(
					"Your first number, " + a + ", must be larger than your second number, " + b + ".");
		}
		//Checks for zero error
		int result = a / b;
		
		//Calculates float result
		
		double resultdbl = (double) a / b;
		System.out.println("\n" + a + " / " + b + " = " + resultdbl);

	}
}
