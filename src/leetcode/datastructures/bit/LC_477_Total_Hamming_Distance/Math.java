package leetcode.datastructures.bit.LC_477_Total_Hamming_Distance;

public class Math {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            for (int j = 0; j < nums.length; j++)
                ones += (nums[j] >> i) & 0x1;
            sum += ones * (nums.length - ones);
        }
        return sum;
    }
}
