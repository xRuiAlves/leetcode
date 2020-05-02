class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; ++i) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int new_sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(new_sum - target) < Math.abs(sum - target)) {
                    sum = new_sum;
                }

                if (new_sum == target) {
                    return target;
                } else if (new_sum < target) {
                    ++left;
                } else {
                    --right;
                }
            }
        }

        return sum;
    }
}