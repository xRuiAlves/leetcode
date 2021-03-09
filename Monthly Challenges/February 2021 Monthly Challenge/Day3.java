/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Day3 {
    private static final int VISITED = Integer.MIN_VALUE;
 
    public boolean hasCycle(ListNode head) {
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val == VISITED) {
                return true;
            }
            
            curr.val = VISITED;
            curr = curr.next;
        }
        
        return false;
    }
}
