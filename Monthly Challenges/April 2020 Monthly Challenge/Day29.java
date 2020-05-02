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

public class Day29 {
    private int best;

    public int maxPathSum(TreeNode root) {
        best = root.val;
        int val = visit(root);
        return Math.max(val, best);
    }

    private int visit(TreeNode node) {
        best = Math.max(best, node.val);

        if (node.left == null && node.right == null) {
            return node.val;
        }
        if (node.left == null) {
            int right_sum = visit(node.right);
            int local_best_choice = node.val + Math.max(right_sum, 0);
            best = Math.max(best, local_best_choice);
            return local_best_choice;
        }
        if (node.right == null) {
            int left_sum = visit(node.left);
            int local_best_choice = node.val + Math.max(0, left_sum);
            best = Math.max(best, local_best_choice);
            return local_best_choice;
        }

        int left_sum = visit(node.left);
        int right_sum = visit(node.right);
        best = Math.max(best, node.val + left_sum + right_sum);
        best = Math.max(best, node.val + Math.max(0, left_sum));
        best = Math.max(best, node.val + Math.max(0, right_sum));
        return Math.max(node.val, Math.max(node.val + left_sum, node.val + right_sum));
    }
}
