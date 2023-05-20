import scala.collection.mutable

object Solution {
  type Graph = mutable.Map[String, mutable.Map[String, Double]]

  case class SearchNode(variableName: String, value: Double)

  private[this] final val NOT_FOUND = -1.0

  def buildEquationGraph(
    equations: List[List[String]],
    values: Array[Double]
  ): Graph = {
    val graph = new mutable.HashMap[String, mutable.Map[String, Double]]()
    equations.zipWithIndex.foreach {
      case (equation, i) => equation match {
        case List(dividend, divisor) =>
          val dividendNeighbor = graph.getOrElse(dividend, new mutable.HashMap[String, Double]())
          val divisorNeighbors = graph.getOrElse(divisor, new mutable.HashMap[String, Double]())
          dividendNeighbor.put(divisor, values(i))
          divisorNeighbors.put(dividend, 1 / values(i))
          graph.put(dividend, dividendNeighbor)
          graph.put(divisor, divisorNeighbors)
        case _ => throw new Exception("Invalid equation!")
      }
    }
    graph
  }

  def calcEquation(graph: Graph, start: String, end: String): Double = {
    val visitedVariableNames = mutable.Set[String]()
    val toVisit = mutable.Queue[SearchNode]()
    toVisit.enqueue(SearchNode(start, 1))

    while (toVisit.nonEmpty) {
      val curr = toVisit.dequeue()

      if (curr.variableName == end) {
        return curr.value
      }

      visitedVariableNames.addOne(curr.variableName)

      graph(curr.variableName).foreach {
        case (neighborVariableName, neighborValue) => if (!visitedVariableNames.contains(neighborVariableName)) {
          toVisit.enqueue(SearchNode(neighborVariableName, curr.value * neighborValue))
        }
      }
    }

    NOT_FOUND
  }

  def calcEquation(equations: List[List[String]], values: Array[Double], queries: List[List[String]]): Array[Double] = {
    val graph = buildEquationGraph(equations, values)
    queries.map {
      case List(dividend, divisor) =>
        if (!graph.contains(dividend) || !graph.contains(divisor)) NOT_FOUND
        else calcEquation(graph, dividend, divisor)
      case _ => throw new Exception("Invalid equation!")
    }.toArray
  }
}
