
/**
 * A program to profile sine approximation algorithms that use
 * the Taylor series expansion of the sine function: 
 * sine(x) = x - x^3/3! + x^5/5! - x^7/7! + x^9/9! .....   
 * @author William Duncan, Johnny Williams III
 * @see SineUtil
 * <pre>
 * Date: 08-31-23
 * Course: csc 3102
 * Project # 0
 * Instructor: Dr. Duncan
 * </pre>
 */

import java.util.Scanner;

public class SineProfiler extends SineUtil {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter angle in radians:");
		double angle = in.nextDouble();
		while (angle > Math.PI || angle < -Math.PI) {
			System.out.println("Angle must be between negative pi and pi. Try again:");
			angle = in.nextDouble();
		}

		System.out.println();
		System.out.printf("naiveSine: (%.4f) = %.4f", angle, naiveSine(angle, 100));
		System.out.printf("\nfastSine: (%.4f) = %.4f\n", angle, fastSine(angle, 100));

		for (int n = 1000; n <= 15000; n += 1000) {
			long naivebegin = System.nanoTime();
			naiveSine(angle, n);
			long naiveclock = (System.nanoTime() - naivebegin) / 1000;
			long fastbegin = System.nanoTime();
			fastSine(angle, n);
			long fastclock = (System.nanoTime() - fastbegin) / 1000;

			System.out.printf("\n%d\t%d\t%d", n, naiveclock, fastclock);
		}
	}
}
