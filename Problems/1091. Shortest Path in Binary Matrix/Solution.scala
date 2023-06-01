import scala.collection.mutable

object Solution {
  case class Coord2D(x: Int, y: Int) {
    def neighbors: Set[Coord2D] = Set(
      Coord2D(x - 1, y - 1),
      Coord2D(x, y - 1),
      Coord2D(x + 1, y - 1),
      Coord2D(x - 1, y),
      Coord2D(x + 1, y),
      Coord2D(x - 1, y + 1),
      Coord2D(x, y + 1),
      Coord2D(x + 1, y + 1)
    )
  }

  type Grid2D = Array[Array[Int]]
  private[this] final val EMPTY_CELL = 0
  private[this] final val SOLUTION_NOT_FOUND = -1

  def isInBounds(grid: Grid2D, coord: Coord2D): Boolean =
    coord.x >= 0 && coord.y >= 0 && coord.y < grid.length && coord.x < grid.head.length

  def isValidPathCell(grid: Grid2D, coord: Coord2D): Boolean =
    isInBounds(grid, coord) && grid(coord.y)(coord.x) == EMPTY_CELL

  def shortestPathBinaryMatrix(grid: Grid2D): Int = {
    if (grid.isEmpty || grid.head.isEmpty || grid.head.head != EMPTY_CELL) {
      return SOLUTION_NOT_FOUND
    }

    val visited = mutable.Set[Coord2D]()
    val toVisit = mutable.Queue[Coord2D]()
    val finalCell = Coord2D(grid.head.length - 1, grid.length - 1)
    toVisit.enqueue(Coord2D(0, 0))

    var distance = 0
    while (toVisit.nonEmpty) {
      distance += 1

      for (_ <- toVisit.indices) {
        val curr = toVisit.dequeue()

        if (curr == finalCell) {
          return distance
        }

        if (!visited.contains(curr)) {
          visited.addOne(curr)
          toVisit.enqueueAll(curr.neighbors.filter(neighbor => isValidPathCell(grid, neighbor)))
        }
      }
    }

    SOLUTION_NOT_FOUND
  }
}
