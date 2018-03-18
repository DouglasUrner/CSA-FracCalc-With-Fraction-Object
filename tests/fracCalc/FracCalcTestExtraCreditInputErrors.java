package fracCalc;

import org.junit.Test;

public class FracCalcTestExtraCreditInputErrors {
	@Test(expected = IllegalArgumentException.class)
	public void InputErrors1() {
		//noinspection ResultOfMethodCallIgnored
		FracCalc.fractionalCalculator("2 + 1 1/2"); }

	@Test(expected = IllegalArgumentException.class)
	public void InputErrors2() {
		//noinspection ResultOfMethodCallIgnored
		FracCalc.fractionalCalculator("1_1/2+2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void InputErrors3() {
		//noinspection ResultOfMethodCallIgnored
		FracCalc.fractionalCalculator("2 % 2");
	}
}
