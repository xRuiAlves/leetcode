import java.util.LinkedList;
import java.util.List;

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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> trees = new LinkedList<>();

        if (l == r) {
            trees.add(new TreeNode(l));
            return trees;
        }
        if (l > r) {
            trees.add(null);
            return trees;
        }

        for (int i = l; i <= r; ++i) {
            List<TreeNode> left_children = generateTrees(l, i - 1);
            List<TreeNode> right_children = generateTrees(i + 1, r);

            for (TreeNode left_child : left_children) {
                for (TreeNode right_child : right_children) {
                    TreeNode root = new TreeNode(i);
                    root.left = left_child;
                    root.right = right_child;
                    trees.add(root);
                }
            }
        }

        return trees;
    }
}
