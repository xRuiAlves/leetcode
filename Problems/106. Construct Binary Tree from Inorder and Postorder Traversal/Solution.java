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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorder_indexes = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            inorder_indexes.put(inorder[i], i);
        }
        return buildNode(postorder, inorder_indexes, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode buildNode(int[] postorder, HashMap<Integer, Integer> inorder_indexes, int postorder_index, int l, int r) {
        if (l > r || postorder_index < 0) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postorder_index]);
        int inorder_index = inorder_indexes.get(node.val);
        node.right = buildNode(postorder, inorder_indexes, postorder_index - 1, inorder_index + 1, r);
        node.left = buildNode(postorder, inorder_indexes, postorder_index - (r - inorder_index + 1), l, inorder_index - 1);
        return node;
    }
}