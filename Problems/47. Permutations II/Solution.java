import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);

        visit(nums, used, res, new LinkedList<>());

        return res;
    }

    private void visit(int[] nums, boolean[] used, List<List<Integer>> res, LinkedList<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new LinkedList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            curr.addLast(nums[i]);
            visit(nums, used, res, curr);
            curr.removeLast();
            used[i] = false;

            while (i < (nums.length - 1) && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
    }
}