import java.util.HashMap;
import java.util.Map;
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

public class Day14 {
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Map<ListNode, ListNode> predecessors = new HashMap<>();
        Stack<ListNode> reversed_nodes = new Stack<>();

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            predecessors.put(curr, prev);
            reversed_nodes.push(curr);
            prev = curr;
            curr = curr.next;
        }

        k = Math.min(k, reversed_nodes.size() - k + 1);
        curr = head;
        for (int i = 1; i < k; ++i) {
            curr = curr.next;
            reversed_nodes.pop();
        }

        ListNode left = curr;
        ListNode right = reversed_nodes.pop();

        if (k == 1) {
            head = right;
        }

        ListNode left_pred = predecessors.get(left);
        ListNode right_pred = predecessors.get(right);

        if (left_pred != null) {
            left_pred.next = right;
        }
        if (right_pred != null) {
            right_pred.next = left;
        }

        ListNode temp = left.next;
        left.next = right.next;
        right.next = temp;

        return head;
    }
}
