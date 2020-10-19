object Day18 {
    def maxProfit(k: Int, prices: Array[Int]): Int = {
        if (k == 0 || prices.length < 2) return 0
        val max_transactions = Math.min(k, prices.length / 2);

        val purchases : Array[Int] = Array.fill(max_transactions)(-prices(0))
        val sales : Array[Int] = new Array[Int](max_transactions)
        
        for (i <- 1 until prices.length) {
            purchases(0) = math.max(purchases(0), -prices(i))
            sales(0) = math.max(sales(0), purchases(0) + prices(i))
            
            for (j <- 1 until max_transactions) {
                purchases(j) = math.max(purchases(j), sales(j - 1) - prices(i))
                sales(j) = math.max(sales(j), purchases(j) + prices(i))
            }
        }
        
        sales(max_transactions - 1)
    }
}
