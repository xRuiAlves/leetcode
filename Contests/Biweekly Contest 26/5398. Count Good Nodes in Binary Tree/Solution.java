/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int count = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        visit(root, root.val);
        return count;
    }

    private void visit(TreeNode node, int max) {
        if (node == null) {
            return;
        }

        if (node.val >= max) {
            ++count;
        }
        
        int new_max = Math.max(max, node.val);
        visit(node.left, new_max);
        visit(node.right, new_max);
    }
}
