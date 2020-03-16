class Solution {
    public int findKthLargest(int[] nums, int k) {
        quicksort(nums, 0, nums.length);
        return nums[nums.length - k];
    }

    private void quicksort(int[] nums, int l, int r) {
        if (l + 1 >= r) {
            return;
        }

        int m = (l + r)/2;
        int pivot = nums[m];
        swap(nums, m, r - 1);

        int i0 = l;
        for (int i = l; i < r - 1; ++i) {
            if (nums[i] < pivot) {
                swap(nums, i, i0);
                ++i0;
            }
        }
        swap(nums, i0, r - 1);

        quicksort(nums, l, i0);
        quicksort(nums, i0 + 1, r);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}