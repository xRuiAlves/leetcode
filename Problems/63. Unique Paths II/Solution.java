class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[] dp = new int[m];

        if (obstacleGrid[n - 1][m - 1] == 1) {
            return 0;
        }

        dp[m - 1] = 1;
        for (int i = n - 1; i >= 0; --i) {
            for (int j = m - 1; j >= 0; --j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j != m - 1) {
                    dp[j] += dp[j + 1];
                }
            }
        }

        return dp[0];
    }
}