class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int[] dp = new int[prices.length];
        int loss = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; ++i) {
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], prices[i] - loss);
            }

            int last_val = i > 2 ? dp[i - 2] : 0;
            loss = Math.min(loss, prices[i] - last_val);
        }

        return dp[dp.length - 1];
    }
}
