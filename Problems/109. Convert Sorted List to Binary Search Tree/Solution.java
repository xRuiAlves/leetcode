/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<Integer> nums = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            nums.add(node.val);
            node = node.next;
        }

        return buildTreeNode(nums, 0, nums.size());
    }

    private TreeNode buildTreeNode(ArrayList<Integer> nums, int i0, int i1) {
        if (i1 <= i0) {
            return null;
        }

        int m = (i0 + i1)/2;
        TreeNode node = new TreeNode(nums.get(m));
        node.right = buildTreeNode(nums, m + 1, i1);
        node.left = buildTreeNode(nums, i0, m);
        return node;
    }
}