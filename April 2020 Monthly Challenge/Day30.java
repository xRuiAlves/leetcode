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

public class Day29 {
    private static final class State {
        int idx;
        TreeNode node;

        State(TreeNode node, int idx) {
            this.idx = idx;
            this.node = node;
        }
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {
        
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(root, 0));

        while(!queue.isEmpty()) {
            State curr_state = queue.poll();
            
            if (curr_state.node == null) {
                continue;
            }

            if (curr_state.idx == arr.length - 1 && curr_state.node.val == arr[curr_state.idx]) {
                if (curr_state.node.left == null && curr_state.node.right == null) {
                    return true;
                }
                continue;
            }

            if (curr_state.node.val != arr[curr_state.idx]) {
                continue;
            }

            queue.add(new State(curr_state.node.left, curr_state.idx + 1));
            queue.add(new State(curr_state.node.right, curr_state.idx + 1));
        }

        return false;
    }
}
