class Solution {
    private static final int UNVISITED = Integer.MIN_VALUE;
    private static final int NOT_FOUND = Integer.MAX_VALUE;

    public int minSubArrayLen(int s, int[] nums) {
        int curr_sum = 0;
        int best = NOT_FOUND;

        for (int i = 0, left = 0; i < nums.length; ++i) {
            curr_sum += nums[i];
            while (curr_sum >= s && left < nums.length) {
                best = Math.min(best, i - left + 1);
                curr_sum -= nums[left];
                ++left;
            }
        }

        return best != NOT_FOUND ? best : 0;
    }
}