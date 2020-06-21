class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[] dp = new int[m];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i + 1 == n && j + 1 == m) {
                    dp[j] = Math.max(1 - dungeon[i][j], 1);
                    continue;
                }
                
                if (i + 1 == n) {
                    dp[j] = Math.max(dp[j + 1] - dungeon[i][j], 1);
                } else if (j + 1 == m) {
                    dp[j] = Math.max(dp[j] - dungeon[i][j], 1);
                } else {
                    int right = Math.max(dp[j + 1] - dungeon[i][j], 1);
                    int down = Math.max(dp[j] - dungeon[i][j], 1);
                    dp[j] = Math.min(right, down);
                }
            }
        }
        
        return dp[0];
    }
}
