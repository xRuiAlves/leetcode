/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Day11 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calcDiameter(root);
        return max;
    }

    private int calcDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left_depth = calcDiameter(node.left);
        int right_depth = calcDiameter(node.right);
        int diameter = left_depth + right_depth;

        max = Math.max(max, diameter);

        return 1 + Math.max(left_depth, right_depth);
    }
}
