class Solution {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int l, int r) {
        if (l == r || l == (r - 1)) {
            return nums[l] > nums[r] ? l : r;
        }

        int m = (l + r) / 2;
        if (nums[m] > nums[l]) {
            if (nums[m - 1] > nums[m]) {
                return search(nums, l, m - 1);
            }
            return search(nums, m, r);
        } else {            
            return search(nums, l, m-1);
        }
    }
}