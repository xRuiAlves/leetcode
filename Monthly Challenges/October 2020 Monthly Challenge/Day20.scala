import scala.collection.mutable

/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var neighbors: List[Node] = List()
 * }
 */

object Day20 {
    val visited = new mutable.HashMap[Node, Node]()

    def cloneGraph(graph: Node): Node = {
        cloneNode(graph)
    }

    def cloneNode(node: Node): Node = {
        if (node == null) return null
        else if (visited.contains(node)) return visited(node)

        val new_node = new Node(node.value)
        visited(node) = new_node

        for (neighbor <- node.neighbors) {
            new_node.neighbors = cloneNode(neighbor) :: new_node.neighbors
        }

        new_node
    }
}
