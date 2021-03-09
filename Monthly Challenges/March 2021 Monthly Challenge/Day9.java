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

public class Day9 {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            return new TreeNode(v, root, null);
        }
        
        addChildren(root, v, d - 1);
        return root;
    }
    
    private void addChildren(TreeNode node, int v, int d) {
        if (node == null) {
            return;
        }
        
        if (d > 1) {
            addChildren(node.left, v, d - 1);
            addChildren(node.right, v, d - 1);
        } else {
            node.left = new TreeNode(v, node.left, null);
            node.right = new TreeNode(v, null, node.right);
        }
    }
}
