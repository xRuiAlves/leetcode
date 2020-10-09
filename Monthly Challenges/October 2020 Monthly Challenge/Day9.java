import java.util.Arrays;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Day9 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildPreoder(root, sb);
        return sb.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isBlank()) {
            return null;
        }
        
        int[] values = Arrays.stream(data.split(" ")).mapToInt(Integer::parseInt).toArray();
        return buildNode(values, 0, values.length - 1);
    }

    private void buildPreoder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        sb.append(node.val).append(" ");
        buildPreoder(node.left, sb);
        buildPreoder(node.right, sb);
    }

    private TreeNode buildNode(int[] values, int l, int r) {
        if (l > r) {
            return null;
        }

        TreeNode node = new TreeNode(values[l]);
        int break_point = l;

        for (int i = l + 1; i <= r; ++i) {
            if (values[i] < node.val) {
                ++break_point;
            } else {
                break;
            }
        }
        
        node.left = buildNode(values, l + 1, break_point);
        node.right = buildNode(values, break_point + 1, r);
        return node;
    }
}
