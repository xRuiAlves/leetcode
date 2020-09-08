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

public class Day8 {
    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root != null) {
            visit(root, 0);
        }
        return sum;
    }
    
    private void visit(TreeNode node, int curr_sum) {
        curr_sum = (curr_sum << 1) + node.val;
        
        if (node.left == null && node.right == null) {
            sum += curr_sum;
        }
        
        if (node.left != null) {
            visit(node.left, curr_sum);
        }
        if (node.right != null) {
            visit(node.right, curr_sum);
        }
    }
}
