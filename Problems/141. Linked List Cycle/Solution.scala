/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Solution {
    def hasCycle(head: ListNode): Boolean = {
        val dummy = new ListNode(-1)
        var curr = head;

        while (curr != null) {
            if (curr.next == dummy) return true
            else {
                val next = curr.next
                curr.next = dummy
                curr = next
            }
        }
        false
    }
}
