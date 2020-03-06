/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode new_list_head = null;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = new_list_head;
            new_list_head = node;
            head = head.next;
        }
        return new_list_head;
    }
}