import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Day24 {
    public TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        for (int i = 1; i < preorder.length; ++i) {
            TreeNode curr = stack.peek();
            int num = preorder[i];

            if (preorder[i] < curr.val) {
                curr.left = new TreeNode(num);
                stack.push(curr.left);
            } else {
                curr = stack.pop();
                while (!stack.isEmpty() && num > stack.peek().val) {
                    curr = stack.pop();
                }
                curr.right = new TreeNode(num);
                stack.push(curr.right);
            }
        }
        
        return root;
    }
}
