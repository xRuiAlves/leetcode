/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Day7 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode node = head;
        ListNode tail = node;
        int size = 0;
        while (node != null) {
            ++size;
            tail = node;
            node = node.next;
        }

        if (size == 0 || size == 1) {
            return head;
        }

        int rotation_amount = k % size;
        if (rotation_amount == 0) {
            return head;
        }

        tail.next = head;
        node = head;
        for (int i = 0; i < size - rotation_amount - 1; ++i) {
            node = node.next;
        }
        
        ListNode ret = node.next;
        node.next = null;
        return ret;
    }
}
