class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        ListNode list_head = res;
        boolean progress = true;
        while (progress) {
            progress = false;
            int best_node_idx = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] == null) {
                    continue;
                }
                progress = true;

                if (lists[i].val < min) {
                    best_node_idx = i;
                    min = lists[i].val;
                }
            }

            if (!progress || min == Integer.MAX_VALUE) {
                break;
            }

            ListNode new_node = new ListNode(min);
            if (res == null) {
                res = new_node;
                list_head = res;
            } else {
                res.next = new_node;
                res = res.next;
            }
            lists[best_node_idx] = lists[best_node_idx].next;
        }

        return list_head;
    }
}