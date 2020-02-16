class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        visit(n, k, res, new LinkedList<>(), 1);
        return res;
    }

    public void visit(int n, int k, List<List<Integer>> res, LinkedList<Integer> curr, int starting) {
        if (curr.size() == k) {
            res.add(new LinkedList<>(curr));
            return;
        }

        for (int i = starting; i <= n; ++i) {
            curr.addLast(i);
            visit(n, k, res, curr, i + 1);
            curr.removeLast();
        }
    }
}