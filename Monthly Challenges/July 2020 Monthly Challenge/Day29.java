public class Day29 {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        
        int[] dp = new int[prices.length];
        int increment = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; ++i) {  
        	if (i > 0) {
        		dp[i] = Math.max(0, Math.max(dp[i-1], prices[i] + increment));
            }

        	int last_val = (i > 2) ? dp[i -2] : 0;

        	if (last_val > prices[i] + increment) {
                increment = last_val - prices[i];
            }
        }
        
        return dp[dp.length - 1];       
    }
}
