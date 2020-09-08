class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k == 0) {
            return 0;
        }
        
        k = Math.min(k, prices.length / 2);

        int[] kth_buy = new int[k];
        int[] kth_sell = new int[k];

        for (int i = 0; i < k; ++i) {
            kth_buy[i] = -prices[0];
            kth_sell[i] = 0;
        }

        for (int day = 1; day < prices.length; ++day) {
            kth_buy[0] = Math.max(kth_buy[0], - prices[day]);
            kth_sell[0] = Math.max(kth_sell[0], kth_buy[0] + prices[day]);

            for (int i = 1; i < k; ++i) {
                kth_buy[i] = Math.max(kth_buy[i], kth_sell[i - 1] - prices[day]);
                kth_sell[i] = Math.max(kth_sell[i], kth_buy[i] + prices[day]);
            }
        }

        return kth_sell[k - 1];
    }
}
