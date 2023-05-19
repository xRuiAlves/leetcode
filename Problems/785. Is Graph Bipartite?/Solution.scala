object Solution {
  def isBipartite(graph: Array[Array[Int]]): Boolean = {
    val colors = new Array[Int](graph.length)

    def isBipartite(node: Int, currColor: Int): Boolean = if (colors(node) == 0) {
      colors(node) = currColor
      graph(node).forall(neighbor => isBipartite(neighbor, -currColor))
    } else colors(node) == currColor

    graph.indices.forall(node => colors(node) != 0 || isBipartite(node, 1))
  }
}
