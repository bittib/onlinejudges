public class Solution {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) {
            return 0;
        }
        int n = M.length;
        DisjointSet ds = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (M[i][j] == 1) {
                    ds.union(i,j);
                }
            }
        }
        return ds.count;
    }

    public static void main(String[] args) {
        t(new int[][]{
            {1,1,0},
            {1,1,0},
            {0,0,1}
        }, 2);

        t(new int[][]{
            {1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},
            {1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},
            {0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},
            {0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},
            {1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},
            {0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},
            {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},
            {0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},
            {0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}
        }, 3);
    }

    public static void t(int[][] matrix, int expectedResult) {
        int actualResult = new Solution().findCircleNum(matrix);
        System.out.printf("Expected result : %d, actual result : %d\n", expectedResult, actualResult);
    }
}
class DisjointSet {
    int[] s;
    public int count;

    public DisjointSet(int n) {
        s = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            s[i] = i;
        }
    }

    public void union(int x, int y) {
        int r1 = root(x);
        int r2 = root(y);
        if (r1 != r2 ) {
            s[r2] = r1;
            count--;
        }
    }

    public int root(int x) {
        while (s[x] != x) {
            x = s[x];
        }

        return x;
    }
}
