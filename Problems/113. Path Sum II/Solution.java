class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        visit(root, sum, res, new LinkedList<>());
        return res;
    }
    
    public void visit(TreeNode node, int sum, List<List<Integer>> res, LinkedList<Integer> curr) {
        if (node == null) {
            return;
        }
        
        curr.addLast(node.val);
        int new_sum = sum - node.val;
        
        if (node.left == null && node.right == null && new_sum == 0) {
            res.add(new LinkedList<>(curr));
        } else {
            visit(node.left, new_sum, res, curr);
            visit(node.right, new_sum, res, curr);
        }
        curr.removeLast();
    }
}