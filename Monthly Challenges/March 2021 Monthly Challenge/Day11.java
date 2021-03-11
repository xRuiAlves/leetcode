public class Day11 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; ++i) {
            dp[i] = -1;

            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    dp[i] = dp[i] == -1
                        ? 1 + dp[i - coin]
                        : Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount];
    }
}
