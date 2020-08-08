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

public class Day8 {
    private int total_sums = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        HashMap<Integer, Integer> sum_occurences = new HashMap<>();
        sum_occurences.put(0, 1);
        visit(root, sum, sum_occurences, 0);
        return total_sums;
    }

    private void visit(TreeNode node, int target, HashMap<Integer, Integer> sum_occurences, int curr_sum) {
        curr_sum += node.val;

        int past_occurences = sum_occurences.getOrDefault(curr_sum - target, 0);
        total_sums += past_occurences;

        sum_occurences.put(curr_sum, sum_occurences.getOrDefault(curr_sum, 0) + 1);

        if (node.left != null) {
            visit(node.left, target, sum_occurences, curr_sum);
        }

        if (node.right != null) {
            visit(node.right, target, sum_occurences, curr_sum);
        }

        sum_occurences.put(curr_sum, sum_occurences.get(curr_sum) - 1);
    }
}
