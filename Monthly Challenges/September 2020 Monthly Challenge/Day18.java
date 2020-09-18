public class Day18 {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        
        int profit = 0;
        int curr_min = prices[0];
        
        for (int i = 1; i < prices.length; ++i) {
            profit = Math.max(profit, prices[i] - curr_min);
            curr_min = Math.min(curr_min, prices[i]);
        }
        
        return profit;
    }
}
