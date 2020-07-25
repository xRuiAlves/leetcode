import java.util.Arrays;

class Solution {
    public int findMin(int[] nums) {
        return Arrays.stream(nums).reduce(nums[0], Math::min);
    }
}
