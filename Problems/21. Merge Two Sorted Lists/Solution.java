/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        
        boolean b1 = false;
        
        if (l1 == null) {
            b1 = false;
        } else if (l2 == null) {
            b1 = true;
        } else {
            if (l1.val < l2.val) {
                b1 = true;
            }
        }
        
        ListNode node = new ListNode(b1 ? l1.val : l2.val);
        ListNode res = node;
        if (b1) {
            l1 = l1.next;
        } else {
            l2 = l2.next;
        }
        
        while (l1 != null || l2 != null) {
            b1 = false;
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    b1 = true;
                }
            } else if (l1 == null) {
                b1 = false;
            } else if (l2 == null) {
                b1 = true;
            }
            
            node.next = new ListNode(b1 ? l1.val : l2.val);
            node = node.next;
            if (b1) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }            
        }
        
        return res;
    }
}
