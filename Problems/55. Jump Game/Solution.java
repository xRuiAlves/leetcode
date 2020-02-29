class Solution {
    public boolean canJump(int[] nums) {
        int target_idx = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; --i) {
            if (i + nums[i] >= target_idx) {
                target_idx = i;
            }
        }
        
        return target_idx == 0;
    }
}