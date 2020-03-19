class Solution {
    public int bulbSwitch(int n) {
        boolean[] dp = new boolean[n];

        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= n; j += i) {
                dp[j - 1] = !dp[j - 1];
            }
        }
        
        int res = 0;
        for (boolean is_on : dp) {
            if (is_on) {
                ++res;
            }
        }
        return res;
    }
}