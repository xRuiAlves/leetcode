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

public class Day16 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode even_head = even;

        while (true) {
            odd.next = even.next;
            even.next = even.next == null ? null : even.next.next;

            if (odd.next == null || even.next == null) {
                if (odd.next != null) {
                    odd = odd.next;
                }
                break;
            }

            odd = odd.next;
            even = even.next;
        }

        odd.next = even_head;
        even.next = null;

        return head;
    }
}
