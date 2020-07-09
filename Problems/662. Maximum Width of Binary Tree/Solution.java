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
    List<Integer> level;

    public int widthOfBinaryTree(TreeNode root) {
        level = new ArrayList<>();
        return search(root, 0, 1);
    }

    private int search(TreeNode node, int depth, int i) {
        if (node == null) {
            return 0;
        }

        if (depth == level.size()) {
            level.add(i);
        }

        int offset = i * 2;
        int best_child = Math.max(
            search(node.left, depth + 1, offset),
            search(node.right, depth + 1, offset + 1)
        );

        return Math.max(best_child, i + 1 - level.get(depth));
    }
}
