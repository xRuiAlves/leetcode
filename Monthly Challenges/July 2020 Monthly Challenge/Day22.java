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

public class Day22 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }

        boolean reverse_layer = false;
        while(!queue.isEmpty()) {
            int num_layer_nodes = queue.size();
            List<Integer> layer = new LinkedList<>();
            for (int i = 0; i < num_layer_nodes; ++i) {
                TreeNode node = queue.poll();
                layer.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            
            if (reverse_layer) {
                Collections.reverse(layer);
            }
            reverse_layer = !reverse_layer;
            res.add(layer);
        }
        
        return res;
    }
}
