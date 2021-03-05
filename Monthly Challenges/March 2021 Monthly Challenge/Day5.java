import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class Day5 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> averages = new LinkedList<>();
        if (root == null) {
            return averages;
        }

        Queue<TreeNode> toVisit = new LinkedList<>();
        toVisit.add(root);

        while (!toVisit.isEmpty()) {
            int level_size = toVisit.size();
            long level_sum = 0;

            for (int i = 0; i < level_size; ++i) {
                TreeNode curr = toVisit.poll();
                level_sum += curr.val;

                if (curr.left != null) {
                    toVisit.add(curr.left);
                }
                if (curr.right != null) {
                    toVisit.add(curr.right);
                }
            }

            averages.add((double) level_sum / level_size);
        }

        return averages;
    }
}
