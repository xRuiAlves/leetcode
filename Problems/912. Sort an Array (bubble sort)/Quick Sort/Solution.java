import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> sortArray(int[] nums) {
        quicksort(nums, 0, nums.length);
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    private void quicksort(int[] nums, int i0, int i1) {
        if (i1 <= i0) {
            return;
        }

        int m = (i0 + i1)/2;
        int pivot = nums[m];
        swap(nums, m, i1 - 1);

        int i = i0;
        for (int j = i0; j < i1 - 1; ++j) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                ++i;
            }
        }
        swap(nums, i, i1 - 1);

        quicksort(nums, i0, i);
        quicksort(nums, i + 1, i1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}