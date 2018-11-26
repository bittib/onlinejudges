package leetcode.datastructures.bit.LC_393_UTF8_Validation;

public class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }

        int i = 0;
        while (i < data.length) {
            if ((data[i] & (1 << 7)) == 0) { // 1 byte
                i++;
                continue;
            }
            // having leading ones -> multi bytes
            int zeros = 0;
            int ones = 0;
            for (int j = 7; j >= 3; j--) {
                if ((data[i] & (1 << j)) != 0) {
                    ones++;
                } else {
                    zeros = 1;
                    break;
                }
            }
            System.out.printf("data[%d] = %d, Ones = %d, Zero = %d\n", i, data[i], ones, zeros);
            if (zeros != 1 || ones <= 1 || i + ones - 1 >= data.length) {
                return false;
            }

            for (int j = 1; j < ones; j++) {
                if ( (data[i + j] & (1 << 7)) == 0 || (data[i+j] & (1 << 6)) != 0 ) {
                    return false;
                }
            }
            i += ones;
        }
        return true;
    }


    public static void main(String[] args) {
        t(new int[]{197, 130, 1});

        t(new int[]{240,162,138,147});
    }

    static void t(int[] data) {
        for (int i : data) {
            System.out.printf("%d \t[ %s ]\n", i, Integer.toBinaryString(i));
        }
        System.out.println();
        boolean result = new Solution().validUtf8(data);
        System.out.printf("Result = %s\n", result);
    }

}
