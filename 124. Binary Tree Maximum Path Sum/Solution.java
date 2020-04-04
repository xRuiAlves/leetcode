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
    private int max_sum = Integer.MIN_VALUE;

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public int maxPathSum(TreeNode root) {
        int base_sum = visit(root);
        max_sum = Math.max(max_sum, base_sum);

        return max_sum;
    }

    public int visit(TreeNode node) {
        max_sum = Math.max(max_sum, node.val);
        if (isLeaf(node)) {
            return node.val;
        }

        if (node.left == null) {
            int right_sum = visit(node.right);
            if (node.val < 0) {
                max_sum = Math.max(max_sum, right_sum);
            }
            return Math.max(node.val, right_sum + node.val);
        }

        if (node.right == null) {
            int left_sum = visit(node.left);
            if (node.val < 0) {
                max_sum = Math.max(max_sum, left_sum);
            }
            return Math.max(node.val, left_sum + node.val);
        }

        int left_sum = visit(node.left);
        int right_sum = visit(node.right);

        int path_option = node.val + right_sum + left_sum;
        int best_single_path = Math.max(left_sum, right_sum);

        max_sum = Math.max(max_sum, path_option);
        max_sum = Math.max(max_sum, best_single_path);

        return Math.max(node.val, node.val + best_single_path);
    }
}