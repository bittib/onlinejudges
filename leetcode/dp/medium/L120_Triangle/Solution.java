import java.util.List;

public class Solution {

    // Time Complexity: O(N^2), Space Complexity: O(N^2)
    public int minimumTotal(List<List<Intgeger>> triangle) {
        int n = triangle.size();
        int[][] d = int[n][n];

        for (int j = 0; j < n; j++) {
            d[n-1][j] = triangle.get(n-1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                d[i][j] = triangle.get(i).get(j) + Math.min(d[i+1][j], d[i+1][j+1]);
            }
        }
        return d[0][0];
    }

    // Time Complexity: O(N^2), Space Complexity: O(N)
    public int mimTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] d = int[n];

        for (int i = 0; i < n; i++) {
            d[i] = triangle.get(n-1).get(i);
        }

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j+1]);
            }
        }
    }
}
