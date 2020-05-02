class Solution {
    private int log2(int num) {
        return (int) Math.ceil(Math.log(num) / Math.log(2));
    }

    public int findMin(int[] nums) {
        int num_iters = log2(nums.length);

        int l = 0;
        int r = nums.length - 1;

        for (int i = 0; i < num_iters; ++i) {
            int m = (l + r)/2;

            if (nums[l] > nums[m]) {
                r = m;
            } else if (nums[r] < nums[m]) {
                l = m;
            } else {
                return nums[l];
            }
        }

        return Math.min(nums[l], nums[r]);
    }
}