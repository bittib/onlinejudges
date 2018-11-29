package leetcode.datastructures.array.medium.LC_50_Power_X_N;

/**
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class Recursion {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        return pow(x, N);
    }

    double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double result = pow(x, n >> 1);
        result = result * result;
        if ((n & 1) != 0) {
            result *= x;
        }
        return result;
    }

}
