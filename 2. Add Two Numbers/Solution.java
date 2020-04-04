/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = (l1.val + l2.val) % 10;
        int b = (l1.val + l2.val) / 10;
        
        ListNode res = new ListNode(a);
        ListNode aux = res;
            
        if (l1.next == null && l2.next == null && b > 0) {
            aux.next = new ListNode(b);
            return res;
        }
        
        while(l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            
            a = (l1.val + l2.val + b) % 10;
            b = (l1.val + l2.val + b) / 10;
            
            aux.next = new ListNode(a);
            aux = aux.next;
            
            if (l1.next == null && l2.next == null && b > 0) {
                aux.next = new ListNode(b);
                break;
            }
        }
        
        ListNode bigger = (l1.next == null) ? l2 : l1;
        while(bigger.next != null) {
            bigger = bigger.next;
            
            a = (bigger.val + b) % 10;
            b = (bigger.val + b) / 10;
            
            aux.next = new ListNode(a);
            aux = aux.next;
            
            if (bigger.next == null && b > 0) {
                aux.next = new ListNode(b);
                break;
            }
        }
        
        return res;
    }
}