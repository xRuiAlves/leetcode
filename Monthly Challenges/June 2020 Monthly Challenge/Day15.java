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

public class Day15 {
    public TreeNode searchBST(TreeNode root, int val) {
        return searchBST(root, val, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode searchBST(TreeNode node, int val, int min_bound, int max_bound) {
        if (node == null || max_bound < val || min_bound > val) {
            return null;
        }

        if (node.val == val) {
            return node;
        }

        TreeNode n1 = searchBST(node.left, val, min_bound, node.val);
        TreeNode n2 = searchBST(node.right, val, node.val, max_bound);
        
        return n1 != null ? n1 : n2;
    }
}
