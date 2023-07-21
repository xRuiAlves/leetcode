object Solution {
  type Matrix = Array[Array[Int]]

  final lazy val deltas = Seq(
    (-1, -1), (-1, 0), (-1, 1),
    (0, -1), (0, 1),
    (+1, -1), (+1, 0), (+1, 1)
  )

  def isAlive(board: Matrix, x: Int, y: Int): Boolean =
    y >= 0 && x >= 0 && y < board.length && x < board(y).length && ((board(y)(x) & 1) != 0)

  def willLive(value: Int, numLiveNeighbors: Int): Boolean = (value == 0 && numLiveNeighbors == 3) ||
    (value == 1 && (numLiveNeighbors == 2 || numLiveNeighbors == 3))

  def getNextGenValue(value: Int, numLiveNeighbors: Int): Int = {
    val nextGenValue = if (willLive(value, numLiveNeighbors)) 1 else 0
    value | (nextGenValue << 1)
  }

  def countNumLiveNeighbors(board: Matrix, x: Int, y: Int): Int = deltas.count {
    case (dx, dy) => isAlive(board, x + dx, y + dy)
  }

  def gameOfLife(board: Matrix): Unit = {
    for (y <- board.indices; x <- board(y).indices)
      board(y)(x) = getNextGenValue(board(y)(x), countNumLiveNeighbors(board, x, y))

    for (y <- board.indices; x <- board(y).indices)
      board(y)(x) >>= 1
  }
}
