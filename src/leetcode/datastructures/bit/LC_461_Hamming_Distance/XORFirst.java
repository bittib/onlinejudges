package leetcode.datastructures.bit.LC_461_Hamming_Distance;

public class XORFirst {

    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((res & 1) != 0) {
                count++;
            }
            res >>= 1;
        }
        return count;
    }


    public int hammingDistance1(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while (res != 0) {
            if ((res & 1) == 1) {
                count++;
            }
            res >>= 1;
        }
        return count;
    }

    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor>>i) & 1;
        }
        return count;
    }

    public int hammingDistance3(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += ((x>>i) & 1) ^ ((y>>i) & 1);
        }
        return count;
    }

}
