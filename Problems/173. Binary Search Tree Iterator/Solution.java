/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private static final class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    ListNode inorder_list;

    public BSTIterator(TreeNode root) {
        inorder_list = inorder(root);
    }

    /** @return the next smallest number */
    public int next() {
        inorder_list = inorder_list.next;
        return inorder_list.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return inorder_list.next != null;
    }

    private ListNode inorder(TreeNode root) {
        ListNode stub = new ListNode(-1);
        ListNode list_tail = stub;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null ||  !stack.isEmpty()) {
            while (curr != null) {
                stack.add(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list_tail.next = new ListNode(curr.val);
            list_tail = list_tail.next;
            curr = curr.right;
        }

        return stub;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */