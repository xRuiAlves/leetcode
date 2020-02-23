class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = (l + r)/2;

            if (nums[m] == target) {
                res[0] = m;
                r = m - 1;
                l = 0;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        l = 0;
        r = nums.length - 1;

        while (l <= r) {
            int m = (l + r)/2;

            if (nums[m] == target) {
                res[1] = m;
                r = nums.length - 1;
                l = m + 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }
}