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

public class Day2 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        TreeNode newRoot = findRoot(root, low, high);
        if (newRoot != null) {
            newRoot.left = trimBST(newRoot.left, newRoot, low, high);
            newRoot.right = trimBST(newRoot.right, newRoot, low, high);
        }
        return newRoot;
    }

    private TreeNode findRoot(TreeNode node, int low, int high) {
        if (node == null || (node.val >= low && node.val <= high)) {
            return node;
        }

        TreeNode leftCandidate = findRoot(node.left, low, high);
        return leftCandidate != null
            ? leftCandidate
            : findRoot(node.right, low, high);
    }

    private TreeNode trimBST(TreeNode node, TreeNode parent, int low, int high) {
        if (node == null) {
            return null;
        }

        if (node.val >= low && node.val <= high) {
            node.left = trimBST(node.left, node, low, high);
            node.right = trimBST(node.right, node, low, high);
            return node;
        } else {
            if (node.left != null && node.left.val >= low) {
                return trimBST(node.left, parent, low, high);
            } else if (node.right != null && node.right.val <= high) {
                return trimBST(node.right, parent, low, high);
            } else {
                return null;
            }
        }
    }
}
