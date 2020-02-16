class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        visit(candidates, target, res, new LinkedList<>(), 0);
        return res;
    }

    public void visit(int[] nums, int sum, List<List<Integer>> res, LinkedList<Integer> curr, int idx) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            LinkedList<Integer> candidate = new LinkedList<>(curr);
            Collections.sort(candidate);
            if (!res.contains(candidate)) {
                res.add(candidate);
            }
            return;
        }

        for (int i = idx; i < nums.length; ++i) {
            curr.addLast(nums[i]);
            visit(nums, sum - nums[i], res, curr, i + 1);
            curr.removeLast();
        }
    }
}
