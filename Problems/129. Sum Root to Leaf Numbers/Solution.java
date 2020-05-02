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
    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        visit(root, 0);

        return sum;
    }

    public void visit(TreeNode node, int curr_sum) {
        int new_sum = curr_sum + node.val;
        
        if (node.left == null && node.right == null) {
            sum += new_sum;
            return;
        }
        
        new_sum *= 10;

        if (node.left != null) {
            visit(node.left, new_sum);
        }
        
        if (node.right != null) {
            visit(node.right, new_sum);
        }
    }
}