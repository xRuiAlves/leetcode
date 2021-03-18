public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int diff = nums[1] - nums[0];
        int count = diff == 0 ? 1 : 2;

        for (int i = 2; i < nums.length; ++i) {
            int new_diff = nums[i] - nums[i - 1];

            if (new_diff == 0) {
                continue;
            }

            if (diff == 0) {
                diff = new_diff;
                ++count;
                continue;
            }

            if (getNumSignal(diff) != getNumSignal(new_diff)) {
                ++count;
                diff = new_diff;
            }
        }
        
        return count;
    }

    private static final int getNumSignal(int num) {
        if (num == 0) {
            return 0;
        }
        return num > 0 ? 1 : -1;
    }
}
