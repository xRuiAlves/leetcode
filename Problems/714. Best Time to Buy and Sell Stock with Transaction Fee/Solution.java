public class Solution {
    private Integer[] buy_cache;
    private Integer[] sell_cache;

    public int maxProfit(int[] prices, int fee) {
        buy_cache = new Integer[prices.length];
        sell_cache = new Integer[prices.length];
        return buy(prices, fee, 0);
    }

    private int buy(int[] prices, int fee, int day) {
        if (day >= prices.length) {
            return 0;
        }

        if (buy_cache[day] == null) {
            buy_cache[day] = Math.max(
                buy(prices, fee, day + 1),
                sell(prices, fee, day + 1) - prices[day] - fee
            );
        }

        return buy_cache[day];
    }

    private int sell(int[] prices, int fee, int day) {
        if (day >= prices.length) {
            return 0;
        }

        if (sell_cache[day] == null) {
            sell_cache[day] = Math.max(
                sell(prices, fee, day + 1),
                buy(prices, fee, day + 1) + prices[day]
            );
        }

        return sell_cache[day];
    }
}
