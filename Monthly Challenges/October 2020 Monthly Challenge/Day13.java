/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Day13 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findListMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        ListNode aux = new ListNode();
        ListNode curr = aux;

        while (!(left == null && right == null)) {
            boolean from_left = true;

            if (left == null) {
                from_left = false;
            } else if (right != null) {
                from_left = left.val < right.val;
            }

            if (from_left) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }

            curr = curr.next;
        }

        return aux.next;
    }

    private ListNode findListMid(ListNode head) {
        ListNode slow = null;

        while (head != null && head.next != null) {
            slow = slow == null ? head : slow.next;
            head = head.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        return mid;
    }
}
