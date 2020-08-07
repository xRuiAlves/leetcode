import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

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

public class Day7 {
    private static final class TreeNodeCoords {
        TreeNode node;
        int x;
        int y;

        public TreeNodeCoords(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    private PriorityQueue<TreeNodeCoords> pqueue;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        pqueue = new PriorityQueue<>(10, (n1, n2) -> {
            if (n1.x == n2.x) {
                if (n1.y == n2.y) {
                    return n1.node.val - n2.node.val;
                }
                return n2.y - n1.y;
            }
            return n1.x - n2.x;
        });

        populatePQueue(root, 0, 0);
        if (pqueue.isEmpty()) {
            return res;
        }

        TreeNodeCoords last = pqueue.poll();
        res.add(new LinkedList<>(Arrays.asList(last.node.val)));

        while (!pqueue.isEmpty()) {
            TreeNodeCoords curr = pqueue.poll();
            if (curr.x != last.x) {
                res.add(new LinkedList<>());
            }

            res.get(res.size() - 1).add(curr.node.val);
            last = curr;
        }

        return res;
    }

    private void populatePQueue(TreeNode node, int x, int y) {
        if (node != null) {
            pqueue.add(new TreeNodeCoords(node, x, y));
            populatePQueue(node.left, x - 1, y - 1);
            populatePQueue(node.right, x + 1, y - 1);
        }
    }
}
