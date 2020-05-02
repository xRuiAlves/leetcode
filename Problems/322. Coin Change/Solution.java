import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; ++i) {
            dp[i] = -1;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    if (dp[i] == -1) {
                        dp[i] = 1 + dp[i - coin];
                    } else {
                        dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                    }
                }
            }
        }

        return dp[amount];
    }
}