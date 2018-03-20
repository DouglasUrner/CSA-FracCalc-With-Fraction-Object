package fracCalc;

import fraction.Fraction;
import net.jqwik.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FracCalcTestTheories {

	@Property
	void addingFractionsWorks(@ForAll("sign") int sA, @ForAll("positive") int wA, @ForAll("positive") int nA, @ForAll("nonZero") int dA,
																 @ForAll("sign") int sB, @ForAll("positive") int wB, @ForAll("positive") int nB, @ForAll("nonZero") int dB)
	{
		String A = partsToFraction(sA, wA, nA, dA);
		String B = partsToFraction(sB, wB, nB, dB);

		double expected = partsToDouble(sA, wA, nA, dA) + partsToDouble(sB, wB, nB, dB);

		String result = (new FracCalc()).calculate(A, "+", B);

		double actual = resultToDouble(result);

		String msg = A + " + " + B + " => " + result;
		assertEquals(expected, actual, 0.000001, msg);
	}

	@Property
	void subtractingFractionsWorks(@ForAll("sign") int sA, @ForAll("positive") int wA, @ForAll("positive") int nA, @ForAll("nonZero") int dA,
														@ForAll("sign") int sB, @ForAll("positive") int wB, @ForAll("positive") int nB, @ForAll("nonZero") int dB)
	{
		String A = partsToFraction(sA, wA, nA, dA);
		String B = partsToFraction(sB, wB, nB, dB);

		double expected = partsToDouble(sA, wA, nA, dA) - partsToDouble(sB, wB, nB, dB);

		String result = (new FracCalc()).calculate(A, "-", B);

		double actual = resultToDouble(result);

		String msg = A + " - " + B + " => " + result;
		assertEquals(expected, actual, 0.000001, msg);
	}


	@Property
	void multiplyingFractionsWorks(@ForAll("sign") int sA, @ForAll("positive") int wA, @ForAll("positive") int nA, @ForAll("nonZero") int dA,
																 @ForAll("sign") int sB, @ForAll("positive") int wB, @ForAll("positive") int nB, @ForAll("nonZero") int dB)
	{
		String A = partsToFraction(sA, wA, nA, dA);
		String B = partsToFraction(sB, wB, nB, dB);

		double expected = partsToDouble(sA, wA, nA, dA) * partsToDouble(sB, wB, nB, dB);

		String result = (new FracCalc()).calculate(A, "*", B);

		double actual = resultToDouble(result);

		String msg = A + " * " + B + " => " + result;
		assertEquals(expected, actual, 0.000001, msg);
	}

	@Property
	void dividingFractionsWorks(@ForAll("sign") int sA, @ForAll("positive") int wA, @ForAll("positive") int nA, @ForAll("nonZero") int dA,
																 @ForAll("sign") int sB, @ForAll("positive") int wB, @ForAll("positive") int nB, @ForAll("nonZero") int dB)
	{
		String A = partsToFraction(sA, wA, nA, dA);
		String B = partsToFraction(sB, wB, nB, dB);

		double expected = partsToDouble(sA, wA, nA, dA) / partsToDouble(sB, wB, nB, dB);

		String result = (new FracCalc()).calculate(A, "/", B);

		double actual = resultToDouble(result);

		String msg = A + " / " + B + " => " + result;
		assertEquals(expected, actual, 0.000001, msg);
	}

	@Provide
	Arbitrary<Integer> sign() {
		return Arbitraries.of(1, -1);
	}

	@Provide
	Arbitrary<Integer> nonZero() {
		return Arbitraries.integers().filter(x -> (x != 0 && x > 0 && x < 100000));
	}

	@Provide
	Arbitrary<Integer> positive() {
		return Arbitraries.integers().filter(x -> (x >= 0 && x < 100000));
	}

	String partsToFraction(int s, int w, int n, int d) {
		return (s < 0 ? "-" : "") + w + "_" + n + "/" + d;
	}

	double partsToDouble(int s, int w, int n, int d) {
		return (s * (w + (n / (double) d)));
	}

	double resultToDouble(String s) {
		String canonical = (new Fraction(s)).toStringCanonical();

		int sign = 1;
		if (canonical.charAt(0) == '-') {
			sign = -1;
			canonical = canonical.substring(1);
		}

		String[] parts = canonical.split("[_/]");

		return sign * (Double.parseDouble(parts[0]) + (Double.parseDouble(parts[1]) / Double.parseDouble(parts[2])));
	}
}