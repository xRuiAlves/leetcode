import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Day4 {    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        
        while (headA != null) {
            visited.add(headA);
            headA = headA.next;
        }
        
        while (headB != null) {
            if (visited.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        
        return null;
    }
}
