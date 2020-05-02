import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid[0].length;
        int dp[] = new int[m];
        dp[0] = grid[0][0];

        for (int j = 1; j < dp.length; ++j) {
            dp[j] = dp[j - 1] + grid[0][j];
        }

        for (int i = 1; i < grid.length; ++i) {
            dp[0] += grid[i][0];
            for (int j = 1; j < grid[i].length; ++j) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[m - 1];
    }
}