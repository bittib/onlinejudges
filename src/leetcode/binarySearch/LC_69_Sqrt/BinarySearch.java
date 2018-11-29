package leetcode.binarySearch.LC_69_Sqrt;

public class BinarySearch {

    public int sqrt(int x) {

        long left = 0, right = x, xx = x;

        while (left <= right) {
            long mid = (left + right) / 2;
            long mm = mid * mid;

            if (mm <= xx && (mid+1)*(mid+1) > xx) {
                return (int)mid;
            }

            if (mm < xx) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0; // shouldn't be here
    }
}
