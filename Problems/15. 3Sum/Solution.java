class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length - 1; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[right] + nums[left];
                if (sum == target) {
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    
                    while (left < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        --right;
                    }
                }

                if (sum > target) {
                    --right;
                } else {
                    ++left;
                }
            }
        }

        return res;
    }
}