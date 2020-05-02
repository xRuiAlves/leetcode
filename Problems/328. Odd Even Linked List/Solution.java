/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;

        boolean to_odd = true;
        while(true) {
            if (to_odd) {
                oddTail.next = evenTail.next;
                if (oddTail.next == null) {
                    break;
                }
                oddTail = oddTail.next;
            } else {
                evenTail.next = oddTail.next;
                if (evenTail.next == null) {
                    break;
                }
                evenTail = evenTail.next;
            }
            to_odd = !to_odd;
        }

        oddTail.next = evenHead;
        return head;
    }
}