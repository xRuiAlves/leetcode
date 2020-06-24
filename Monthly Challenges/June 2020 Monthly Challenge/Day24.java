public class Day24 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            int num_iters = i/2;

            int count = 0;
            for (int j = 0; j < num_iters; ++j) {
                count += dp[j] * dp[i - 1 - j];
            }
            dp[i] = 2*count;

            if (i % 2 == 1) {
                dp[i] += (dp[i/2] * dp[i/2]);
            }
        }

        return dp[n];
    }
}
