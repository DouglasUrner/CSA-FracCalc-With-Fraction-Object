package fraction;

public class Fraction {
	// Fields (instance variables)
	boolean negative;
	int whole;
	int numerator;
	int denominator;

	/*
	 * Core Constructors
	 */

	// From a String.
	public Fraction(String s) {

		int begin = 0;
		int underscore = s.indexOf('_');
		int slash = s.indexOf('/');

		// Negative?
		if (s.charAt(0) == '-') {
			this.negative = true;
			begin = 1;
		}

		if (underscore == -1 && slash == -1 && s.length() > begin) {
			// Whole number only.
			this.whole = Integer.parseInt(s.substring(begin));
			this.numerator = 0;
			this.denominator = 1;
		} else if (underscore > 0 && slash > 2  && s.length() >= begin + 5) {
			// Whole and fraction.
			this.whole = Integer.parseInt(s.substring(begin, underscore));
			this.numerator = Integer.parseInt(s.substring(underscore + 1, slash));
			this.denominator = Integer.parseInt(s.substring(slash + 1));
		} else if (underscore == -1 && slash > 0 && s.length() >= begin + 3) {
			// Fraction only.
			this.whole = 0;
			this.numerator = Integer.parseInt(s.substring(begin, slash));
			this.denominator = Integer.parseInt(s.substring(slash + 1));
		} else {
			// Malformed fraction.
			// TODO: Handle malformed input.
		}
	}

	// From individual component values, sign from most significant - used for the result of a calculation.
	public Fraction(int w, int n, int d) {
		// Figure out the sign.
		if ((w >= 0 && n >= 0 && d >= 0) || (w >= 0 && n < 0 && d < 0)) {
			this.setNegative(false);
		} else {
			this.setNegative(true);
		}

		this.setWhole(Math.abs(w));
		this.setNumerator(Math.abs(n));
		if (d != 0) {
			this.setDenominator(Math.abs(d));
		} else {
			throw new IllegalArgumentException("Denominator can't be zero.");
		}
	}

	// Duplicate from another Fraction - used by toString() to avoid side effects.
	public Fraction(Fraction f) {
		this.negative = f.negative;
		this.whole = f.whole;
		this.numerator = f.numerator;
		this.denominator = f.denominator;
	}

	// Accessors (getters)

	public boolean isNegative() { return this.negative; }
	public int whole() { return this.whole; }
	public int numerator() { return this.numerator; }
	public int denominator() { return this.denominator; }

	/*
	 * Mutators (setters) - public interface for changing the form of fractions.
	 */

	public void improper() {
		this.numerator = this.whole * this.denominator + this.numerator;
		this.whole = 0;
	}

	public void reduce() {
		int w = this.whole + this.numerator / this.denominator;
		int n = this.numerator % this.denominator;
		int d = n > 0 ? this.denominator : 1;

		if (n > 0) {
			int gcf = gcf(this.numerator, this.denominator);
			n /= gcf;
			d /= gcf;
		}

		this.setWhole(w);
		this.setNumerator(n);
		this.setDenominator(d);
	}

	/*
	 * Internal Setters
	 *
	 * Not public because it doesn't make sense to set individual components of a fraction. We use them to
	 * ensure that error checking and validation happens in one place.
	 */

	void setNegative(boolean negative) {
		this.negative = negative;
	}

	void setWhole(int whole) {
		this.whole = whole;
	}

	void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	/*
	 * Utility Methods
	 */

	public boolean equals(Fraction that) {
		return ((this.negative == that.negative) && (this.whole == that.whole) &&
				(this.numerator == that.numerator) &&	(this.denominator == that.denominator));
	}

	public int sign() { return this.negative ? -1 : 1; }

	@Override
	public String toString() {
		// So we don't change the original.
		Fraction f = new Fraction(this);

		f.reduce();

		if (f.whole == 0 && f.numerator == 0) {
			// Zero.
			return "0";
		} else if (f.whole > 0 && f.numerator == 0) {
			// Whole only.
			return f.sign() * f.whole + "";
		} else if (f.whole > 0 && f.numerator > 0) {
			// Whole and fraction.
			return f.sign() * f.whole + "_" + f.numerator + "/" + f.denominator;
		} else {
			// Fraction only.
			return f.sign() * f.numerator + "/" + f.denominator;
		}
	}

	/*
	 * Helpers
	 */
	static int gcf(int n, int d) {
		int gcf = 1;

		for (int i = 2; i <= n; i++) {
			if (n % i == 0 && d % i == 0)
				gcf = i;
		}

		return gcf;
	}
}
