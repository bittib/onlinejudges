package leetcode.datastructures.array.medium.LC_50_Power_X_N;

public class Iterative {

    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        return pow(x, N);
    }

    public double pow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        double ans = 1;

        while (n > 0) {
            if ((n & 1) != 0) {
                ans *= x;
            }
            x = x * x;
        }
        return ans;
    }
}
