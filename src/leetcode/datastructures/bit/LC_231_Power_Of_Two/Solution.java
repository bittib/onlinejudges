package leetcode.datastructures.bit.LC_231_Power_Of_Two;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        int count = 0;

        while (n > 0) { // make sure we can handle the negative integer correctly
            n = n & (n -1);
            count++;
        }
        return count == 1;
    }

    public boolean isPowerOfTwo1(int n) {
        return (n > 0 && (n & (n-1)) == 0);
    }
}
