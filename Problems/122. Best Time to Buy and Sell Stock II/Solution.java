import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
        int[] cache = new int[prices.length];
        Arrays.fill(cache, -1);
        return maxProfit(prices, 0, cache);
    }

    public int maxProfit(int[] prices, int start, int[] cache) {
        if (start >= prices.length - 1) {
            return 0;
        }
        
        if (cache[start] != -1) {
            return cache[start];
        }

        int best = 0;
        int min_idx = start;

        for (int i = start + 1; i < prices.length; ++i) {
            if (prices[i] > prices[min_idx]) {
                int price_candidate = prices[i] - prices[min_idx] + maxProfit(prices, i + 1, cache);
                best = Math.max(best, price_candidate);
            } else if (prices[i] < prices[min_idx]) {
                min_idx = i;
            }
        }

        cache[start] = best;
        return best;
    }
}
