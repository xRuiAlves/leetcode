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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode last_visited = null;

        while(!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                curr = stack.peek();
                if (curr.right != null && curr.right != last_visited) {
                    curr = curr.right;
                } else {
                    last_visited = stack.pop();
                    res.add(curr.val);
                    curr = null;
                }
            }
        }

        return res;
    }
}