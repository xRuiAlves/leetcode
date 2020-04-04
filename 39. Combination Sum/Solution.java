class Solution {
    public void visit(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> curr, int idx, int sum) {
        if (sum > target) {
            return;
        }

        if (sum == target) {
            res.add(new LinkedList<>(curr));
            return;
        }

        for (int i = idx; i < candidates.length; ++i) {
            curr.addLast(candidates[i]);
            visit(candidates, target, res, curr, i, sum + candidates[i]);
            curr.removeLast();
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();

        visit(candidates, target, res, new LinkedList<Integer>(),0, 0);

        return res;
    }
}