package leetcode.datastructures.bit.LC_342_Power_Of_Four;

public class Solution {

    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }

    public boolean isPowerOfFour1(int num) {
        if (num <= 0 || (num & (num -1)) != 0) {
            return false;
        }
        int zeroAfterOne = 0;
        while (num > 1) {
            num >>= 1;
            zeroAfterOne++;
        }
        return zeroAfterOne % 2 == 0;
    }
}
