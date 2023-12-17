/**
 * Provides implementations of Sine Approximation Algorithms and auxiliary
 * methods
 * 
 * @author William Duncan, Johnny Williams III
 * 
 *         <pre>
 * Date: 08-31-23
 * Course: csc 3102
 * Project # 0
 * Instructor: Dr. Duncan
 *         </pre>
 */

public class SineUtil {
	/**
	 * Computes the factorial of the specified number
	 * 
	 * @param n the number whose factorial is to be determined
	 * @return n!
	 * @throw IllegalArgumentException when n < 0
	 */
	private static double factorial(int n) {
		double factor = 1;
		if (n < 0) {
			throw new IllegalArgumentException("N must be greater than or equal to 0");
		} else {
			if (n == 0) {
				return 1;
			} else {
				for (int i = n; i > 0; i--) {
					factor *= i;
				}
				return (factor);
			}
		}
	}

	/**
	 * Computes the specified power
	 * 
	 * @param x the base of the power
	 * @param n the exponent of the power
	 * @return x^n
	 * @throw IllegalArgumentException when x = 0 and n <= 0
	 */
	private static double pow(double x, int n) {
		double result = 1;
		if (x == 0 || n <= 0) {
			throw new IllegalArgumentException("X can't be 0 and N must be greater than 0");
		} else {
			for (int i = 0; i < n; i++) {
				result = result * x;
			}
			return result;
		}
	}

	/**
	 * Computes the sine of an angle using the Taylor Series approximation of the
	 * sine function and naive exponentiation
	 * 
	 * @param x angle in radians
	 * @param n number of terms
	 * @return sine(x) = x - x^3/3! + x^5/5! - x^7/7! .....
	 * @throw IllegalArgumentException when n <= 0
	 */
	public static double naiveSine(double x, int n) {
		double sin = 0;
		if (n <= 0) {
			throw new IllegalArgumentException("UNDEFINED");
		} else {
			for (int i = 1; i <= n; i++) {
				if (i % 2 == 0) {
					sin -= (pow(x, (2 * i) - 1)) / factorial(((2 * i) - 1));
				} else {
					sin += (pow(x, (2 * i) - 1)) / factorial(((2 * i) - 1));
				}
			}
			return sin;
		}
	}

	/**
	 * Computes the sine of an angle using the Taylor Series approximation of the
	 * sine function and fast exponentiation
	 * 
	 * @param x angle in radians
	 * @param n number of terms
	 * @return sine(x) = x - x^3/3! + x^5/5! - x^7/7! .....
	 * @throw IllegalArgumentException when n <= 0
	 */
	public static double fastSine(double x, int n) {

		if (n <= 0) {
			throw new IllegalArgumentException("UNDEFINED");
		} else {
			double s = x;
			double denom = 3;
			double factor = -1;
			double base = x;

			for (int i = 2; i <= n; i++) {
				base = base * (x / denom) * (x / (denom - 1));
				denom = denom + 2;
				s = s + (factor * base);
				factor = factor * (-1);
			}
			return s;
		}
	}
}
