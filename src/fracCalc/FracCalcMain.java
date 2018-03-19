package fracCalc;

import java.util.Scanner;

import static fracCalc.FracCalc.fractionalCalculator;

public class FracCalcMain {
	public static void main(String[] args) {
		// TODO: CP 1 - Read a line of input from user, pass to fractionalCalculator() then print the result.
		// TODO: CP 3 - Loop processing user input until the user types 'quit' then exit.
		Scanner stdin = new Scanner(System.in);

		while (true) {
			String input = stdin.nextLine();
			if (input.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.println(fractionalCalculator(input));
		}
		stdin.close();
	}
}
