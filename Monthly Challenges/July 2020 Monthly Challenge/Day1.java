public class Day1 {
    public int arrangeCoins(int n) {
        for (int i = 0;; ++i) {
            n -= i;
            if (n < 0) {
                return i - 1;
            }
        }
    }
}
