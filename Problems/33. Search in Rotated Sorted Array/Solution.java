class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        // Find max in array
        int l = 0;
        int r = nums.length - 1;
        int num_iters = Math.max(1, (int) Math.ceil(Math.log(nums.length) / Math.log(2)));

        for (int i = 0; i < num_iters; ++i) {
            int m = (l + r) / 2;

            if (nums[l] > nums[m]) {
                r = m;
            } else {
                l = m;
            }
        }

        r = (nums[r] > nums[l]) ? r : l;
        l = (r + 1) % nums.length;

        for (int i = 0; i < num_iters + 1; ++i) {
            int m = (l <= r ? (l + r)/2 : (l + (nums.length - l + r)/2)) % nums.length;

            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = (m == 0 ? nums.length - 1 : m - 1);
            } else {
                l = (m + 1) % nums.length;
            }
        }

        return -1;
    }
}
