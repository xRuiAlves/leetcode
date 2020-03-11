import java.util.HashMap;

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorder_indexes = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            inorder_indexes.put(inorder[i], i);
        }
        return buildNode(preorder, inorder_indexes, 0, 0, inorder.length - 1);
    }

    private TreeNode buildNode(int[] preorder, HashMap<Integer, Integer> inorder_indexes, int preoder_index, int l, int r) {
        if (l > r || preoder_index >= preorder.length) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preoder_index]);
        int inorder_index = inorder_indexes.get(node.val);
        node.left = buildNode(preorder, inorder_indexes, preoder_index + 1, l, inorder_index - 1);
        node.right = buildNode(preorder, inorder_indexes, preoder_index + inorder_index - l + 1, inorder_index + 1, r);
        return node;
    }
}