import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> sortArray(int[] nums) {
        return merge_sort(nums, 0, nums.length);
    }

    private LinkedList<Integer> merge_sort(int[] nums, int i0, int i1) {
        if (i1 - i0 == 1) {
            return new LinkedList<>(Arrays.asList(nums[i0]));
        }

        int m = (i0 + i1)/2;
        LinkedList<Integer> left_list = merge_sort(nums, i0, m);
        LinkedList<Integer> right_list = merge_sort(nums, m, i1);

        LinkedList<Integer> sorted_list = new LinkedList<>();
        while(!(left_list.isEmpty() && right_list.isEmpty())) {
            if (left_list.isEmpty()) {
                sorted_list.addLast(right_list.pollFirst());
            } else if (right_list.isEmpty()) {
                sorted_list.addLast(left_list.pollFirst());
            } else {
                if (left_list.peekFirst() < right_list.peekFirst()) {
                    sorted_list.addLast(left_list.pollFirst());
                } else {
                    sorted_list.addLast(right_list.pollFirst());
                }
            }
        }

        return sorted_list;
    }
}
