package leetcode.datastructures.bit.LC_268_Missing_Number;
import java.util.*;

public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int x : nums) {
            sum += x;
        }
        return n * (1 + n) / 2 - sum;
    }

    public int missingNumber1(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        for (int i = 1; i <= nums.length; i++) {
            res ^= i;
        }
        return res;
    }

    public int missingNumber2(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > mid) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return right;
    }
}
