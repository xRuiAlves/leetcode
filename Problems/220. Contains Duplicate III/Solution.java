class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 1; j <= k && i + j < nums.length; ++j) {
                if (Math.abs((long)nums[i] - nums[i + j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}