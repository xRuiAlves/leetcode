import scala.collection.mutable

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

object Day27 {
    def detectCycle(head: ListNode): ListNode = {
        val visited = new mutable.HashSet[ListNode]()
        var curr = head

        while (curr != null) {
            if (visited.contains(curr)) return curr
            else {
                visited.add(curr)
                curr = curr.next
            }
        }

        null
    }
}
