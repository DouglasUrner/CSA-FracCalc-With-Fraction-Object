package fracCalc;

import org.junit.Test;

public class FracCalcTestCheckpoint3Addition {
	@Test public void testCheckpoint3_AdditionSimple3() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "4_3/7", FracCalc.fractionalCalculator("1_1/7 + 3_2/7"));}
	@Test public void testCheckpoint3_AdditionWholeNumbers2() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "1", FracCalc.fractionalCalculator("2/3 + 1/3"));}
	@Test public void testCheckpoint3_AdditionWholeNumbers7() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "1021778", FracCalc.fractionalCalculator("124543 + 897235"));}
	@Test public void testCheckpoint3_AdditionWithNegatives4() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "-1_1/4", FracCalc.fractionalCalculator("-3_3/4 + 2_2/4"));}
	@Test public void testCheckpoint3_AdditionImproperFractionsAndReductions2() {FracCalcTestALL.assertForEarlyCheckpoints(null, null, "1_1/20", FracCalc.fractionalCalculator("4/5 + 2/8"));}
	@Test public void testCheckpoint3_AdditionCombined4() { FracCalcTestALL.assertForEarlyCheckpoints(null, null, "62_11/19", FracCalc.fractionalCalculator("0 + 34_543/19"));}
}
