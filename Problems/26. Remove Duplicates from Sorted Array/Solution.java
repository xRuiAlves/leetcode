class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int left = 1, right = 1;
        while (right < nums.length) {
            if (nums[right] == nums[right - 1]) {
                ++right;
                continue;
            } else {
                nums[left] = nums[right];
                ++left;
                ++right;
            }
        }
        
        return left;
    }
}