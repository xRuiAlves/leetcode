import java.util.Arrays;

public class Day14 {
    private int[] robberies;
    
    public int rob(int[] nums) {
        robberies = new int[nums.length];
        Arrays.fill(robberies, -1);
        return rob(nums, 0);
    }

    private int rob(int[] nums, int day) {
        if (day >= nums.length) {
            return 0;
        }
        
        if (robberies[day] != -1) {
            return robberies[day];
        }

        robberies[day] = Math.max(nums[day] + rob(nums, day + 2), rob(nums, day + 1));
        return robberies[day];
    }
}
