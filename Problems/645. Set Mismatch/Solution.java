import java.util.Arrays;

public class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int n1 = 0, n2 = 0;

        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                n1 = nums[i];
            }
        }

        if (nums[0] != 1) {
            return new int[]{n1, 1};
        }

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] == nums[i - 1] + 2) {
                n2 = nums[i - 1] + 1;
                break;
            }
        }

        if (n2 == 0) {
            n2 = nums.length;
        }

        return new int[]{n1, n2};
    }
}
