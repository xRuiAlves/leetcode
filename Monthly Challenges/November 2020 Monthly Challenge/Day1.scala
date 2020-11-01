/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */

object Day1 {
    def getDecimalValue(head: ListNode): Int = {
        var curr = head
        var value = 0
        while (curr != null) {
            value = (value << 1) + curr.x
            curr = curr.next
        }
        value
    }
}
