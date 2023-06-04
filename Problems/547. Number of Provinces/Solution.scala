import scala.collection.mutable

object Solution {
  def findCircleNum(isConnected: Array[Array[Int]]): Int = {
    val visited = mutable.Set[Int]()
    var numProvinces = 0

    isConnected.indices.foreach(i => {
      if (!visited.contains(i)) {
        dfs(isConnected, visited, i)
        numProvinces += 1
      }
    })

    numProvinces
  }

  def dfs(graph: Array[Array[Int]], visited: mutable.Set[Int], initialNode: Int): Unit = {
    val toVisit = mutable.Stack[Int]()
    toVisit.push(initialNode)

    while (toVisit.nonEmpty) {
      val curr = toVisit.pop()

      if (!visited.contains(curr)) {
        visited.addOne(curr)
        val neighbors = graph(curr).zipWithIndex.filter(_._1 == 1).map(_._2)
        toVisit.pushAll(neighbors)
      }
    }
  }
}
