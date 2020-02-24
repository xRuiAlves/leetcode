import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        boolean[] used = new boolean[nums.length];
        visit(nums, used, res, new LinkedList<Integer>());

        return res.stream().distinct().collect(Collectors.toList());
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
        }
    }
}