package fracCalc;

import fraction.Fraction;

public class FracCalc {
	/*
	 * IMPORTANT DO NOT DELETE OR CHANGE THE SIGNATURE OF THIS FUNCTION
	 *
	 * This function will be used to test your code.
	 *
	 * This function takes a String 'input' and produces the result
	 *
	 * input is a fraction string that needs to be evaluated.  For your
	 * program, this will be the user input.
	 *     e.g. input ==> "1/2 + 3/4"
	 *
	 * The function should return the result of the fraction after it
	 * has been calculated
	 *    e.g. return ==> "1_1/4"
	 */
	public static String fractionalCalculator(String input)
	{
		// TODO: CP 1 - Return String passed as input.
		// TODO: CP 2 - Return 2nd operand exactly as it was passed.
		// TODO: CP 3 - Return 2nd operand as "whole:N numerator:N denominator:N" - apply sign to the 1st non-zero value.
		// TODO: CP 4 - Return the calculated result (which may be an improper and unreduced fraction).
		// TODO: Final - Return a proper fraction reduced to its simplest form.

		// Components of the equation as indexes in  tokens[];
		int left = 0;
		int operator = 1;
		int right = 2;

		// Split the input into tokens on spaces.
		String[] tokens = input.split(" ");

		return calculate(tokens[left],tokens[operator], tokens[right]).toString();

		//Fraction right = new Fraction(tokens[2]);

		//return "whole:" + right.whole() + " numerator:" + right.numerator() + " denominator:" + right.denominator();
	}

	// TODO: Use the space below for any helper methods that you need.
	static Fraction calculate(String left, String operator, String right) {
		boolean negative = false;
		int numerator = 0;
		int denominator = 1;

		// Parse fractions.
		Fraction l = new Fraction(left);
		Fraction r = new Fraction(right);

		// Convert into improper form.
		l.improper();
		r.improper();

		switch (operator) {
			case "+":
				numerator = (l.sign() * l.numerator() * r.denominator()) + (r.sign() * r.numerator() * l.denominator());
				denominator = l.denominator() * r.denominator();
				break;

			case "-":
				numerator = (l.sign() * l.numerator() * r.denominator()) - (r.sign() * r.numerator() * l.denominator());
				denominator = l.denominator() * r.denominator();
				break;

			case "*":
				numerator = (l.sign() * l.numerator()) * (r.sign() * r.numerator());
				denominator = l.denominator() * r.denominator();
				break;

			case "/":
				numerator = (l.sign() * l.numerator()) * (r.sign() * r.denominator());
				denominator = l.denominator() * r.numerator();
				break;

			default:
				// TODO: handle unknown operators.
		}

		return new Fraction(0, numerator, denominator);
	}
}
