package fraction;

public class Fraction {
	// Fields (instance variables)
	boolean negative;
	int whole;
	int numerator;
	int denominator;

	// Core Constructors

	public Fraction(String s) {
		// Empty string
		if (s.length() == 0) {
			throw new IllegalArgumentException("ERROR: can't create Fraction from empty string");
		}
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
			throw new IllegalArgumentException("ERROR: Malformed Fraction string'" + s + "'.");
		}
	}

	public Fraction(int w, int n, int d) {
		if (w < 0) {
			this.negative = true;
			this.whole = Math.abs(w);
		}
		if (n < 0 && w == 0) {
			this.negative = true;
			this.numerator = Math.abs(n);
		} else {
			// TODO: better error handling.
			throw new IllegalArgumentException("Numerator");
		}
		if (d != 0 && d > 0) {
			this.denominator = d;
		} else {
			// TODO: better error handling.
			throw new IllegalArgumentException("Denominator");
		}
	}

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

	// Mutators (setters)

	public void improper() {
		this.numerator = this.whole * this.denominator + this.numerator;
		this.whole = 0;
	}

	public void reduce() {
		this.whole += this.numerator / this.denominator;
		this.numerator %= this.denominator;

		int gcf = gcf(this.numerator, this.denominator);
		this.numerator /= gcf;
		this.denominator /= gcf;
	}

	// Utility methods

	String sign() { return this.negative ? "-" : ""; }

	@Override
	public String toString() {
		Fraction f = new Fraction(this); // So we don't change the original.
		String s;

		f.reduce();

		if (f.whole == 0 && f.numerator == 0) {
			// Zero.
			return "0";
		} else if (f.whole > 0 && f.numerator == 0) {
			// Whole only.
			return f.sign() + f.whole;
		} else if (f.whole > 0 && f.numerator > 0) {
			// Whole and fraction.
			return f.sign() + f.whole + "_" + f.numerator + "/" + f.denominator;
		} else {
			// Fraction only.
			return f.sign() + f.numerator + "/" + f.denominator;
		}
	}

	// Helpers

	static int gcf(int n, int d) {
		int gcf = 1;

		for (int i = 2; i < n; i++) {
			if (n % i == 0 && d % i == 0)
				gcf = i;
		}

		return gcf;
	}
}
