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
    private String smallest = null;

    public String smallestFromLeaf(TreeNode root) {
        visit(root, "");

        return smallest;
    }

    public void visit(TreeNode node, String curr) {
        String new_str = String.valueOf((char) ((int)'a' + node.val)) + curr;

        if (node.left == null && node.right == null) {
            if (smallest == null) {
                smallest = new_str;
            } else {
                smallest = smallest.compareTo(new_str) <= 0 ? smallest : new_str;
            }
        }

        if (node.left != null) {
            visit(node.left, new_str);
        }

        if (node.right != null) {
            visit(node.right, new_str);
        }
    }
}