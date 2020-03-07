class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int best = -1;
        int min = prices[0];
        
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] <= min) {
                min = prices[i];
            } else {
                best = Math.max(best, prices[i] - min);
            }
        }
        
        return Math.max(0, best);
    }
}