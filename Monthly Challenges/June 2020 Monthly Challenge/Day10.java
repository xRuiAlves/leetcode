public class Day10 {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l + 1 < r) {
            int m = (l + r) / 2;

            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                r = m;
            } else if (nums[m] < target) {
                l = m;
            }
        }

        if (target > nums[r]) {
            return r + 1;
        }
        if (target == nums[r]) {
            return r;
        }
        if (target > nums[l]) {
            return l + 1;
        }
        return l;
    }
}
