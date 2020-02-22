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
    private HashMap<Integer, Integer> sums = new HashMap<>();
    private int solution = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        visit(root, sum, 0);

        return solution;
    }

    public void visit(TreeNode node, int sum, int curr_sum) {
        curr_sum += node.val;

        if (curr_sum == sum) {
            ++solution;
        }

        int times_sum_occured = sums.getOrDefault(curr_sum - sum, 0);
        solution += times_sum_occured;

        sums.put(curr_sum, sums.getOrDefault(curr_sum, 0) + 1);

        if (node.left != null) {
            visit(node.left, sum, curr_sum);
        }

        if (node.right != null) {
            visit(node.right, sum, curr_sum);
        }

        sums.put(curr_sum, sums.get(curr_sum) - 1);
    }
}