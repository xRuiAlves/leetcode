/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid_node = getMidNode(head);
        ListNode l2 = mid_node.next;
        mid_node.next = null;

        ListNode l1 = sortList(head);
        l2 = sortList(l2);

        return mergeLists(l1, l2);
    }

    private ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode stub = new ListNode(-1);
        ListNode curr = stub;

        while (!(l1 == null && l2 == null)) {
            if (l2 == null) {
                curr.next = l1;
                l1 = l1.next;
            } else if (l1 == null) {
                curr.next = l2;
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        return stub.next;
    }
}