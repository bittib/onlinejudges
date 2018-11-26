package leetcode.datastructures.bit.LC_338_Counting_Bits;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 */
public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            ans[i] = popcount(i);
        }
        return ans;
    }

    int popcount(int x) {
        int count = 0;
        while (x > 0) {
            x &= (x - 1);
            count++;
        }
        return count;
    }
}
