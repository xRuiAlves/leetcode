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

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (n1, n2) -> n1.val - n2.val);

        for (ListNode list_head : lists) {
            if (list_head != null) {
                queue.offer(list_head);
            }
        }

        if (queue.isEmpty()) {
            return null;
        }

        ListNode head = queue.poll();
        ListNode tail = head;
        if (head.next != null) {
            queue.offer(head.next);
        }

        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null) {
                queue.offer(tail.next);
            }
        }

        return head;
    }
}
