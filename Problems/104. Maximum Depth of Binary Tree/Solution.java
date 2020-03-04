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
    private int max_depth = 0;

    public int maxDepth(TreeNode root) {
        if (root != null) {
            visit(root, 1);
        }
        return max_depth;
    }
    
    private void visit(TreeNode node, int depth) {
        max_depth = Math.max(max_depth, depth);
        
        if (node.left != null) {
            visit(node.left, depth + 1);
        }
        if (node.right != null) {
            visit(node.right, depth + 1);
        }
    }
}