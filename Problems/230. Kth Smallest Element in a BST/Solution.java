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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();

        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            --k;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }

        return -1;
    }
}