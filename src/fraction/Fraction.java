package fraction;

public class Fraction {
    /*
     * Declare the fields (also called properties or instance variables) that
     * define the Fraction object. These are declared private and not static.
     * Private so that we can control how they are accessed, and not static so
     * that each Fraction can be unique.
     */
    private boolean isNegative;
    private int whole;
    private int numerator;
    private int denominator;

    /**
     * Constructor
     *
     * @param s - a String containing a fraction in the form [-]W_N/D where the
     *          leading sign is optional, W is an optional whole number part,
     *          N is the numerator, and D is the denominator. The following are
     *          examples of legal input:
     *              1
     *              -1_2/3
     *              2/3
     *              0
     */
    public Fraction(String s) {
        /*
         * The obvious Fraction constructor, you may discover others as you work
         * on the project. You can create any constructors that you need so long
         * as they have different signatures (in this case, the set of formal
         * parameters).
         *
         * The constructor's job is to initialize, give starting values to, the
         * Fraction object. Note that while the declaration looks a lot like a
         * method it does not include a type and the name is identical (including
         * captializatior) to the class name.
         */

        /*
         * Here pseudocode for one way to parse the string and initialize the
         * Fraction. As long as you pass the tests, your method (should be) good -
         * or else you've found a bug it the tests...
         */

        // Check charAt(0) to see if first charcter in String is '-'.
        // If it is, set isNegative to true.

        // Use indexOf() to find the "landmarks" ("_" and "/") in the String that identify
        // the boundaries between the whole number part, the numerator, and the denominator.

        // Use substring() to extract the individual parts of the fraction based on which
        // of the landmarks are present. Assign default values as needed.

        if () {
            // Whole number only.
            whole = Integer.parseInt(s.substring(begin));
            numerator = 0;
            denominator = 1;
        } else if () {
            // Whole plus fraction.
        } else if () {
            // Fraction only.
        } else {
            // Bad fraction format.
        }
    }

    /*
     * Accessors (getters)
     *
     * These are the public interface that client classes use to access the state of
     * the class. They are typically super simple, there is rarely more to do that to
     * simply return the current value of the field.
     */
    public boolean isNegative() { return this.isNegative; }
    public int whole() { return  }
    public int numerator() { return  }
    public int denominator() { return  }

    /*
     * Mutators (setters)
     *
     * These methods are the public interface that allow cliets to change the state of
     * the class - while still allowing us to control access and ensure that the state
     * remains consistent.
     */

    /**
     * improper() - Convert the Fraction to improper form and set this.whole to 0.
     */
    public void improper() {

    }

    /**
     * reduce() - Reduce a fraction to simplified form.
     */
    public void reduce() {

    }

    /*
     * Utility Methods.
     */

    /**
     * toString() - create a String representing a Fraction in canonical form suitable for printing,
     *              or for construting a new Fraction.
     *
     * @return - String in canonical form ([-]W_N/D).
     */
    @Override
    public String toString() {
        // A start, good enough for Checkpoint 3.
        return (this.isNegative ? "-" : "") + this.whole + "_" + this.numerator + "/" + this.denominator;
    }

    /*
     * Internal Methods - not visible outside of the class.
     */

    /**
     * gcf() - Find the greatest common factor of n and d.
     *
     * @param n - numerator
     * @param d - denominator
     * @return  - greatest common factor
     */
    private int gcf(int n, int d) {

    }
}

