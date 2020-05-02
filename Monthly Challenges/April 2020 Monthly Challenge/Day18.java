public class Day18 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[n - 1] = grid[m - 1][n - 1];
        for (int i = n - 2; i >= 0; --i) {
            dp[i] = dp[i + 1] + grid[m - 1][i];
        }

        for (int i = m - 2; i >= 0; --i) {
            dp[n - 1] += grid[i][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}
