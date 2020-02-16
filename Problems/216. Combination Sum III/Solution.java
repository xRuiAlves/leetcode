class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        visit(k, n, res, 1, new LinkedList<>(), 0);
        return res;
    }

    public void visit(int k, int n, List<List<Integer>> res, int n0, LinkedList<Integer> curr, int sum) {
        if (sum == n && curr.size() == k) {
            res.add(new LinkedList<>(curr));
            return;
        }

        if (curr.size() >= k || sum >= n) {
            return;
        }

        for (int i = n0; i <= 9; ++i) {
            curr.addLast(i);
            visit(k, n, res, i + 1, curr, sum + i);
            curr.removeLast();
        }
    }
}