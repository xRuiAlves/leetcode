class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 0) {
            return head;
        }

        int size = 0;
        ListNode node = head;

        while (node != null) {
            ++size;
            node = node.next;
        }

        if (n > size) {
            return head;
        }

        int idx_to_remove = size - n;
        
        if (idx_to_remove == 0) {
            return head.next;
        }

        node = head;
        for (int i = 0; i < idx_to_remove - 1; ++i) {
            node = node.next;
        }

        node.next = node.next.next;

        return head;
    }
}