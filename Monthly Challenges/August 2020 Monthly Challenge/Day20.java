import java.util.Stack;

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

public class Day20 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            stack.add(curr);
            curr = curr.next;
        }

        int list_size = stack.size();
        curr = head;

        for (int i = 0; i < list_size/2; ++i) {
            ListNode new_node = stack.pop();
            new_node.next = (list_size % 2 == 0 && i == list_size/2 - 1) ? null : curr.next;
            curr.next = new_node;
            curr = new_node.next;
        }
        
        if (curr != null) {
            curr.next = null;
        }
        
        return;
    }
}
