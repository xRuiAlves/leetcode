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

public class Day26 {
    private int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root != null) {
            visit(root, 0);
        }
        return res;
    }

    private void visit(TreeNode node, int sum) {
        sum += node.val;
        
        if (node.left == null && node.right == null) {
            res += sum;
            return;
        } 
        
        if (node.left != null) {
            visit(node.left, sum * 10);
        }

        if (node.right != null) {
            visit(node.right, sum * 10);
        }
    }
}
