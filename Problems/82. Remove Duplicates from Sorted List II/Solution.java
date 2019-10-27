/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = null;
        ListNode curr = res;
        
        while (head != null) {
            int x = head.val;
            boolean bad = false;
            if (head.next != null && head.next.val == x) {
                bad = true;
                while (head != null && head.val == x) {
                    head = head.next;
                }
            }
            if (!bad) {
                if (res == null) {
                    res = new ListNode(x);
                    curr = res;
                } else {
                    curr.next = new ListNode(x);
                    curr = curr.next;
                }
                head = head.next;
            }
        }
        
        return res;
    }
}
