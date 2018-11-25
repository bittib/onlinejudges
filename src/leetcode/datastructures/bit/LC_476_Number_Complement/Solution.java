package leetcode.datastructures.bit.LC_476_Number_Complement;

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 *
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 *
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 *
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */
public class Solution {

    /**
     * 求一个数补数。
     * 通过分析题目给出的例子，我们知道需要做的就是对该整数二进制中除了左前的leading zero bits,其他每个位翻转一下就行了。
     * 换句话说，翻转的起始位置上从最高位的1开始的，前面的0是不能被翻转的，所以我们从高往低遍历，如果遇到第一个1了后，我们的flag就赋值为true，
     * 然后就可以进行翻转了。
     *
     * 按位翻转flip操作的实现是通过和该位上为1的mask进行异或实现的。
     *
     */
    public int findComplement(int num) {
        boolean start = false;
        for (int i = 31; i >= 0; i--) {
            if ((num & (1 << i)) != 0) {
                start = true;
            }
            if (start) {
                num ^= (1 << i);
            }
        }
        return num;
    }

    /**
     * 仔细观察上面的方法，每一位其实我们都通过异或操作和该位置1的mask进行按位翻转的。那么我们其实可以直接对所有的需要翻转的位直接进行翻转
     * 只要我们能知道该数最高位的1所在位置，就可以构造一个长度和该数据所占位置一样长的一个掩码mask，然后将该数直接和mask进行异或即可。
     *
     * 例如：6的二进制是110，我们的构造的掩码为mask=111，两者异或则为001，即是所要的结果。
     *
     */
    public int findComplement1(int num) {
        int mask = 1, temp = num;

        while (temp > 0) {
            temp = temp >> 1;
            mask = mask >> 1;
        }
        return num ^ (mask - 1);
    }
}
