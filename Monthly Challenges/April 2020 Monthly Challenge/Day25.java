public class Day25 {
    public boolean canJump(int[] nums) {
        int j = 0;
        
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == 0 && j == 0) {
                return false;
            }
            j = Math.max(j, nums[i]);
            --j;
        }
        
        return true;
    }
}
