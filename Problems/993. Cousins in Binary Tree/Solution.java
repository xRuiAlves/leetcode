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
class Solution {
    private static final class NodeInfo {
        int depth;
        int parent;

        NodeInfo(int depth, int parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        NodeInfo nx = find(x, root, 0, null);
        NodeInfo ny = find(y, root, 0, null);

        return nx != null
            && ny != null
            && nx.parent != ny.parent
            && nx.depth == ny.depth;
    }

    private NodeInfo find(int target, TreeNode node, int depth, TreeNode parent) {
        if (node == null) {
            return null;
        }

        if (node.val == target) {
            return new NodeInfo(depth, parent == null ? -1 : parent.val);
        }

        NodeInfo nleft = find(target, node.left, depth + 1, node);
        NodeInfo nright = find(target, node.right, depth + 1, node);

        if (nleft != null) {
            return nleft;
        }
        return nright;
    }
}
