import java.util.*;

public class Day27 {
    public int numSquares(int n) {
        List<Integer> squares = new LinkedList<>();
        for (int i = 1; ; ++i) {
            int square = i*i;
            if (square <= n) {
                squares.add(square);
            } else {
                break;
            }
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        return dp[n];
    }
}
