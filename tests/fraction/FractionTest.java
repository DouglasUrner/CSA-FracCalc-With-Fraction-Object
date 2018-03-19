package fraction;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {
	/*
	 * Properly formed inputs.
	 */
	@Test public void FractionTest_Fraction1() {
		String s = "42";
		Fraction f = new Fraction(s);
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 42, f.whole);
		assertEquals("numerator in: " + s, 0, f.numerator);
		assertEquals("denominator in: " + s, 1, f.denominator);

		s = "1_2/3";
		f = new Fraction(s);
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 1, f.whole);
		assertEquals("numerator in: " + s, 2, f.numerator);
		assertEquals("denominator in: " + s, 3, f.denominator);

		s = "4/5";
		f = new Fraction(s);
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 0, f.whole);
		assertEquals("numerator in: " + s, 4, f.numerator);
		assertEquals("denominator in: " + s, 5, f.denominator);

		// Negatives

		s = "-84";
		f = new Fraction(s);
		assertTrue("'" + s + "'should be negative", f.negative);
		assertEquals("whole in: " + s, 84, f.whole);
		assertEquals("numerator in: " + s, 0, f.numerator);
		assertEquals("denominator in: " + s, 1, f.denominator);

		s = "-6_7/8";
		f = new Fraction(s);
		assertTrue("'" + s + "'should be negative", f.negative);
		assertEquals("whole in: " + s, 6, f.whole);
		assertEquals("numerator in: " + s, 7, f.numerator);
		assertEquals("denominator in: " + s, 8, f.denominator);

		s = "-9/10";
		f = new Fraction(s);
		assertTrue("'" + s + "'should be negative", f.negative);
		assertEquals("whole in: " + s, 0, f.whole);
		assertEquals("numerator in: " + s, 9, f.numerator);
		assertEquals("denominator in: " + s, 10, f.denominator);
	}

	@Test public void FractionTest_Fraction2() {
		String s = "42";
		Fraction f = new Fraction(42, 0, 1);
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 42, f.whole);
		assertEquals("numerator in: " + s, 0, f.numerator);
		assertEquals("denominator in: " + s, 1, f.denominator);

		s = "1_2/3";
		f = new Fraction(1, 2, 3);
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 1, f.whole);
		assertEquals("numerator in: " + s, 2, f.numerator);
		assertEquals("denominator in: " + s, 3, f.denominator);

		s = "4/5";
		f = new Fraction(0, 4 ,5);
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 0, f.whole);
		assertEquals("numerator in: " + s, 4, f.numerator);
		assertEquals("denominator in: " + s, 5, f.denominator);

		// Negatives

		s = "-84";
		f = new Fraction(-84, 0, 1);
		assertTrue("'" + s + "'should be negative", f.negative);
		assertEquals("whole in: " + s, 84, f.whole);
		assertEquals("numerator in: " + s, 0, f.numerator);
		assertEquals("denominator in: " + s, 1, f.denominator);

		s = "-6_7/8";
		f = new Fraction(-6, 7, 8);
		assertTrue("'" + s + "'should be negative", f.negative);
		assertEquals("whole in: " + s, 6, f.whole);
		assertEquals("numerator in: " + s, 7, f.numerator);
		assertEquals("denominator in: " + s, 8, f.denominator);

		s = "-9/10";
		f = new Fraction(0, -9, 10);
		assertTrue("'" + s + "'should be negative", f.negative);
		assertEquals("whole in: " + s, 0, f.whole);
		assertEquals("numerator in: " + s, 9, f.numerator);
		assertEquals("denominator in: " + s, 10, f.denominator);
	}

	@Test public void FractionTest_Fraction3() {
		String s = "-6_7/8";
		Fraction f1 = new Fraction(s);
		Fraction f2 = new Fraction(f1);
		assertTrue("'" + s + "'should be negative", f2.negative);
		assertEquals("whole in: " + s, 6, f2.whole);
		assertEquals("numerator in: " + s, 7, f2.numerator);
		assertEquals("denominator in: " + s, 8, f2.denominator);
	}

	@Test
	public void FractionTest_isNegative1() {
		String s = "1_2/3";
		Fraction f = new Fraction(s);
		assertFalse(f.isNegative());
	}

	@Test
	public void FractionTest_isNegative2() {
		String s = "-4_5/6";
		Fraction f = new Fraction(s);
		assertTrue(f.isNegative());
	}

	/*
	 * The "heavy lifting" is done in the constructor tests. All we (probably) have to
	 * do is to verify that we get back the value that we expect for one fraction.
	 */

	@Test
	public void FractionTest_whole1() {
		String s = "1_2/3";
		Fraction f = new Fraction(s);
		assertEquals(1, f.whole());
	}

	@Test
	public void FractionTest_numerator1() {
		String s = "1_2/3";
		Fraction f = new Fraction(s);
		assertEquals(2, f.numerator());
	}

	@Test
	public void FractionTest_denominator1() {
		String s = "1_2/3";
		Fraction f = new Fraction(s);
		assertEquals(3, f.denominator());
	}

	@Test
	public void FractionTest_improper1() {
		String s = "1_2/3";
		Fraction f = new Fraction(s);
		f.improper();
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 0, f.whole);
		assertEquals("numerator in: " + s, 5, f.numerator);
		assertEquals("denominator in: " + s, 3, f.denominator);
	}

	@Test
	public void FractionTest_improper2() {
		String s = "42";
		Fraction f = new Fraction(s);
		f.improper();
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 0, f.whole);
		assertEquals("numerator in: " + s, 42, f.numerator);
		assertEquals("denominator in: " + s, 1, f.denominator);
	}

	@Test
	public void FractionTest_improper3() {
		String s = "0";
		Fraction f = new Fraction(s);
		f.improper();
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 0, f.whole);
		assertEquals("numerator in: " + s, 0, f.numerator);
		assertEquals("denominator in: " + s, 1, f.denominator);
	}

	@Test
	public void FractionTest_improper4() {
		String s = "2/3";
		Fraction f = new Fraction(s);
		f.improper();
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 0, f.whole);
		assertEquals("numerator in: " + s, 2, f.numerator);
		assertEquals("denominator in: " + s, 3, f.denominator);
	}

	@Test
	public void FractionTest_reduce1() {
		String s = "42/3";
		Fraction f = new Fraction(s);
		f.reduce();
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 14, f.whole);
		assertEquals("numerator in: " + s, 0, f.numerator);
		assertEquals("denominator in: " + s, 1, f.denominator);
	}


	@Test
	public void FractionTest_reduce2() {
		String s = "3_8/16";
		Fraction f = new Fraction(s);
		f.reduce();
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 3, f.whole);
		assertEquals("numerator in: " + s, 1, f.numerator);
		assertEquals("denominator in: " + s, 2, f.denominator);
	}

	@Test
	public void FractionTest_reduce3() {
		String s = "2/3";
		Fraction f = new Fraction(s);
		f.reduce();
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 0, f.whole);
		assertEquals("numerator in: " + s, 2, f.numerator);
		assertEquals("denominator in: " + s, 3, f.denominator);
	}

	@Test
	public void FractionTest_reduce4() {
		String s = "0";
		Fraction f = new Fraction(s);
		f.reduce();
		assertFalse("'" + s + "' should not be negative", f.negative);
		assertEquals("whole in: " + s, 0, f.whole);
		assertEquals("numerator in: " + s, 0, f.numerator);
		assertEquals("denominator in: " + s, 1, f.denominator);
	}

	@Test
	public void FractionTest_equals1() {
		String s = "1_2/3";
		Fraction f1 = new Fraction(s);
		Fraction f2 = new Fraction(f1);
		assertTrue(f1.toString() + " should equal " + f2.toString(), f1.equals(f2));
	}

	@Test
	public void FractionTest_equals2() {
		String s = "1_2/3";
		Fraction f1 = new Fraction(s);
		Fraction f2 = new Fraction(-4, 5, 6);
		assertTrue(f1.toString() + " should not equal " + f2.toString(), !f1.equals(f2));
	}

	@Test
	public void FractionTest_toString1() {
		String s = "1_2/3";
		Fraction f1 = new Fraction(s);
		Fraction f2 = new Fraction(f1);
		assertEquals(s, f1.toString());
		// Check that toString() didn't change f1.
		assertTrue(f1.equals(f2));
	}

	@Test
	public void FractionTest_toString2() {
		String s = "-4_5/6";
		Fraction f1 = new Fraction(s);
		Fraction f2 = new Fraction(f1);
		assertEquals(s, f1.toString());
		// Check that toString() didn't change f1.
		assertTrue(f1.equals(f2));
	}

	@Test
	public void FractionTest_toString3() {
		String s = "7";
		Fraction f1 = new Fraction(s);
		Fraction f2 = new Fraction(f1);
		assertEquals(s, f1.toString());
		// Check that toString() didn't change f1.
		assertTrue(f1.equals(f2));
	}

	@Test
	public void FractionTest_toString4() {
		String s = "8/9";
		Fraction f1 = new Fraction(s);
		Fraction f2 = new Fraction(f1);
		assertEquals(s, f1.toString());
		// Check that toString() didn't change f1.
		assertTrue(f1.equals(f2));
	}

	@Test
	public void FractionTest_toString5() {
		String s = "42/3";
		Fraction f1 = new Fraction(s);
		Fraction f2 = new Fraction(f1);
		assertEquals("14", f1.toString());
		// Check that toString() didn't change f1.
		assertTrue(f1.equals(f2));
	}

	@Test
	public void FractionTest_toString6() {
		String s = "-0";
		Fraction f1 = new Fraction(s);
		Fraction f2 = new Fraction(f1);
		assertEquals("0", f1.toString());
		// Check that toString() didn't change f1.
		assertTrue(f1.equals(f2));
	}

	// Implementation dependent below.

	@Test
	public void FractionTest_gcf1() {
		String s = "0/3";
		Fraction f = new Fraction(s);
		assertEquals(1, Fraction.gcf(f.numerator(), f.denominator()));
	}

	@Test
	public void FractionTest_gcf2() {
		String s = "1_2/3";
		Fraction f = new Fraction(s);
		assertEquals(1, Fraction.gcf(f.numerator(), f.denominator()));
	}

	@Test
	public void FractionTest_gcf3() {
		String s = "42/21";
		Fraction f = new Fraction(s);
		assertEquals(21, Fraction.gcf(f.numerator(), f.denominator()));
	}

	@Test
	public void FractionTest_sign1() {
		String s = "-1";
		Fraction f = new Fraction(s);
		assertEquals(-1, f.sign());
	}

	@Test
	public void FractionTest_sign2() {
		String s = "2";
		Fraction f = new Fraction(s);
		assertEquals(1, f.sign());
	}
}