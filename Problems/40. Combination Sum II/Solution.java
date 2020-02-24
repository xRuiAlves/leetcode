import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();

        visit(candidates, target, res, new LinkedList<>(), 0);

        return res;
    }

    private void visit(int[] nums, int sum, List<List<Integer>> res, LinkedList<Integer> curr, int idx) {
        if (sum == 0) {
            res.add(new LinkedList<>(curr));
            return;
        }

        if (sum < 0) {
            return;
        }

        for (int i = idx; i < nums.length; ++i) {
            curr.add(nums[i]);
            visit(nums, sum - nums[i], res, curr, i + 1);
            curr.removeLast();

            while (i < (nums.length - 1) && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
    }
}