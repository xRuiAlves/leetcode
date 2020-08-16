public class Day16 {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }

        int buy_first = 0 - prices[0];
        int sell_first = 0;
        int buy_second = 0 - prices[0];
        int sell_second = 0;

        for(int i = 1; i < prices.length; i++) {
            buy_first = Math.max(buy_first, -prices[i]);
            sell_first = Math.max(sell_first, buy_first + prices[i]);
            buy_second = Math.max(buy_second, sell_first - prices[i]);
            sell_second = Math.max(sell_second, buy_second + prices[i]);
        }

        return sell_second;
    }
}
