package fracCalc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FracCalcTestFinalDivision {
	@Test public void testDivisionBasic1() {assertEquals("9/16", FracCalc.fractionalCalculator("3/4 / 4/3"));}
	@Test public void testDivisionBasic2() {assertEquals("2_1/4", FracCalc.fractionalCalculator("3/2 / 2/3"));}
	@Test public void testDivisionBasic3() {assertEquals("9457", FracCalc.fractionalCalculator("9457 / 1"));}
	@Test public void testDivisionBasic4() {assertEquals("6/11", FracCalc.fractionalCalculator("6 / 11"));}
	@Test public void testDivisionBasic5() {assertEquals("4/9", FracCalc.fractionalCalculator("4 / 9"));}
	@Test public void testDivisionBasic6() {assertEquals("1", FracCalc.fractionalCalculator("23 / 23"));}
	@Test public void testDivisionBasic7() {assertEquals("2_6/7", FracCalc.fractionalCalculator("20 / 7"));}
	@Test public void testDivisionBasic8() {assertEquals("13/24", FracCalc.fractionalCalculator("1_1/12 / 2"));}
	@Test public void testDivisionBasic9() {assertEquals("1", FracCalc.fractionalCalculator("3/4 / 3/4"));}

	@Test public void testDivisionWithNegatives1() {assertEquals("1_5/8", FracCalc.fractionalCalculator("-13 / -8"));}
	@Test public void testDivisionWithNegatives2() {assertEquals("-2803", FracCalc.fractionalCalculator("-2803 / 1"));}
	@Test public void testDivisionWithNegatives3() {assertEquals("-12457", FracCalc.fractionalCalculator("12457 / -1"));}
	@Test public void testDivisionWithNegatives4() {assertEquals("45236", FracCalc.fractionalCalculator("-45236 / -1"));}
	@Test public void testDivisionWithNegatives5() {assertEquals("-2_6/7", FracCalc.fractionalCalculator("-20 / 7"));}
	@Test public void testDivisionWithNegatives6() {assertEquals("1_13/32", FracCalc.fractionalCalculator("-3_3/4 / -2_2/3"));}
	@Test public void testDivisionWithNegatives7() {assertEquals("-1_13/32", FracCalc.fractionalCalculator("-3_3/4 / 2_2/3"));}
	@Test public void testDivisionWithNegatives8() {assertEquals("-1_13/32", FracCalc.fractionalCalculator("3_3/4 / -2_2/3"));}

	@Test public void testDivisionWithZero1() {assertEquals("0", FracCalc.fractionalCalculator("-0 / 98701"));}
	@Test public void testDivisionWithZero2() {assertEquals("0", FracCalc.fractionalCalculator("-0 / -98701"));}
	@Test public void testDivisionWithZero3() {assertEquals("0", FracCalc.fractionalCalculator("0 / -98701"));}
	@Test public void testDivisionWithZero4() {assertEquals("0", FracCalc.fractionalCalculator("0 / 37569"));}
	@Test public void testDivisionWithZero5() {assertEquals("0", FracCalc.fractionalCalculator("0 / 46/27"));}
	@Test public void testDivisionWithZero6() {assertEquals("0", FracCalc.fractionalCalculator("0/24 / 1/46"));}
	@Test public void testDivisionWithZero7() {assertEquals("0", FracCalc.fractionalCalculator("0/11 / 6/7"));}

	@Test public void testDivisionCombined1() {assertEquals("2_2/3", FracCalc.fractionalCalculator("16/4 / 3/2"));}
	@Test public void testDivisionCombined2() {assertEquals("-2_2/3", FracCalc.fractionalCalculator("16/4 / -3/2"));}
	@Test public void testDivisionCombined3() {assertEquals("6_661/5520", FracCalc.fractionalCalculator("-38_3/72 / -4_82/37"));}
	@Test public void testDivisionCombined4() {assertEquals("-5/21", FracCalc.fractionalCalculator("1_2/3 / -5_6/3"));}
}
