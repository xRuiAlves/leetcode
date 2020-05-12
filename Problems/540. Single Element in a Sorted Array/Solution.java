class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        boolean mult4;

        while (l < r) {
            mult4 = ((r - l) % 4) == 0;
            int m = (l + r)/2;

            if (m + 1 < nums.length && nums[m] == nums[m + 1]) {
                if (mult4) {
                    l = m + 2;
                } else {
                    r = m - 1;
                }
            } else if (m > 0 && nums[m] == nums[m - 1]) {
                if (mult4) {
                    r = m - 2;
                } else {
                    l = m + 1;
                }
            } else {
                return nums[m];
            }
        }

        return nums[l];
    }
}
