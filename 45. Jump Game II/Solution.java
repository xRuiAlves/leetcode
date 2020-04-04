class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 0;

        for (int i = nums.length - 2; i >= 0; --i) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= nums[i] && i + j < nums.length; ++j) {
                if (dp[i + j] < dp[i]) {
                    dp[i] = dp[i + j] + 1;
                }
            }
        }

        return dp[0];
    }
}