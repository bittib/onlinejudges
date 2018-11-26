package leetcode.datastructures.bit.LC_338_Counting_Bits;

public class Power2 {

    /**
     *
     * 当一个数为2的整数幂的时候，1的个数为1，比如2（10) 和4(100)，8(1000)
     *
     * 在这之后就是前一个序列的数+1 比如 9(1001) = 1(1) + 8 (1) = 2
     *
     * 就是把一个数分解为小于它的最大2的整数幂 + x
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];

        int pow2 = 1, prev = 1;
        for (int i = 1; i <= num; i++) {
            if (i == pow2) {
                ans[i] = 1;
                prev = 1;
                pow2 <<= 1;
            } else {
                ans[i] = ans[prev] + 1;
                prev++;
            }
        }
        return ans;
    }

    /**
     * 任何一个数要么是偶数，要么是奇数。而奇数又可以分解偶数+i%2
     * An easy recurrence for this problem is f[i] = f[i / 2] + i % 2.
     */
    public int[] countBits1(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
