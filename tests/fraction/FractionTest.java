package fraction;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {

	@Test
	public void FractionTest_toString() {
		Fraction f = new Fraction();
		assertEquals("1_2/3", f.toString());
	}
}