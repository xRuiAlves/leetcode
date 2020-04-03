public class Day3 {
    public int maxSubArray(int[] nums) {
        int best = nums[0];
        int curr = 0;
        
        for (int num : nums) {
            curr += num;
            best = Math.max(best, curr);
            
            if (curr < 0) {
                curr = 0;
            }
        }
        
        return best;
    }
}
