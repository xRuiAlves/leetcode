import scala.collection.mutable

object Solution {
  case class Coord2D(x: Int, y: Int) {
    def neighbors: Set[Coord2D] = Set(
      Coord2D(x - 1, y),
      Coord2D(x + 1, y),
      Coord2D(x, y - 1),
      Coord2D(x, y + 1),
    )
  }

  private[this] type Grid2D = Array[Array[Int]]

  private[this] final val WATER = 0
  private[this] final val ISLAND1 = 1
  private[this] final val ISLAND2 = 2

  def findInitialIsland(grid: Grid2D, coordId: Int = 0): Coord2D = {
    val y = coordId / grid.head.length
    val x = coordId % grid.head.length
    grid(y)(x) match {
      case WATER => findInitialIsland(grid, coordId + 1)
      case _ => Coord2D(x, y)
    }
  }

  def floodFill(grid: Grid2D, island2: mutable.Set[Coord2D], coord: Coord2D): Unit =
    if (isInBounds(grid, coord) && grid(coord.y)(coord.x) == ISLAND1) {
      grid(coord.y)(coord.x) = ISLAND2
      island2.addOne(coord)
      coord.neighbors.foreach(neighbor => floodFill(grid, island2, neighbor))
    }


  def isInBounds(grid: Grid2D, coord: Coord2D): Boolean =
    coord.y >= 0 && coord.y < grid.length && coord.x >= 0 && coord.x < grid.head.length

  def shortestBridge(grid: Grid2D, island2: mutable.Set[Coord2D]): Int = {
    val visited = mutable.Set[Coord2D]()
    val toVisit = new mutable.Queue[Coord2D]()
    toVisit.enqueueAll(island2)
    var depth = 0

    while (toVisit.nonEmpty) {
      for (_ <- toVisit.indices) {
        val curr = toVisit.dequeue()

        if (!visited.contains(curr)) {
          visited.addOne(curr)

          if (grid(curr.y)(curr.x) == ISLAND1) {
            return depth - 1
          }

          toVisit.addAll(curr
            .neighbors
            .filter(neighbor => isInBounds(grid, neighbor))
            .filter(neighbor => grid(neighbor.y)(neighbor.x) != ISLAND2)
          )
        }
      }
      depth += 1
    }

    throw new Exception("Solution not found!")
  }

  def shortestBridge(grid: Grid2D): Int = {
    val initial: Coord2D = findInitialIsland(grid)
    val island2 = mutable.Set[Coord2D]()
    floodFill(grid, island2, initial)
    shortestBridge(grid, island2)
  }
}
