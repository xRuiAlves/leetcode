/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        visit(root, res);
        return res;
    }

    private void visit(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        visit(node.left, res);
        res.add(node.val);
        visit(node.right, res);
    }
}