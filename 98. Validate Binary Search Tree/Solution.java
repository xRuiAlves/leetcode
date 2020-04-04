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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, long lower_bound, long upper_bound) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower_bound || node.val >= upper_bound) {
            return false;
        }

        if (node.left == null && node.right == null) {
            return true;
        }

        if (node.left != null) {
            if (!isValid(node.left, lower_bound, node.val)) {
                return false;
            }
        }

        if (node.right != null) {
            if (!isValid(node.right, node.val, upper_bound)) {
                return false;
            }
        }

        return true;
    }
}