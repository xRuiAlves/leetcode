import java.util.Arrays;

public class Solution {
    private static final int MODULO = (int) (1e9 + 7);

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long width = getMaxDiff(verticalCuts, w);
        long height = getMaxDiff(horizontalCuts, h);
        
        return (int) ((width * height) % MODULO);
    }

    private int getMaxDiff(int[] nums, int finalNum) {
        Arrays.sort(nums);
        int max = Math.max(nums[0], finalNum - nums[nums.length - 1]);
        for (int i = 1; i < nums.length; ++i) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }
}
