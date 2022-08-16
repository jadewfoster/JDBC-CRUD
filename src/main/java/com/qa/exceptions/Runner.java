package com.qa.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Maths maths = new Maths();
		
		boolean loop = true;

		while (loop) {

			try {
				System.out.println("Please enter two numbers:");
				int a = scanner.nextInt();
				int b = scanner.nextInt();

				System.out.println("You have entered " + a + " and " + b + ".");

				maths.divide(a, b);
				loop = false;
			}

			catch (InputMismatchException ie) {
				System.out.println("Please enter integers rather than words. Try again:");
				scanner.next();
				continue;
			}

			catch (ArithmeticException ae) {
				System.out.println("0 is not an allowed entry. Try again:");
				scanner.next();
				continue;
			}

			catch (DivisionRuleException dre) {
				System.out.println(dre.getMessage());
				scanner.next();
				continue;
			}

			catch (Exception e) {
				e.printStackTrace();
				scanner.next();
				continue;
			}

		}

	}
}
