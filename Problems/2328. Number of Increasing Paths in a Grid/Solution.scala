object Solution {
  private[this] final val MOD = (1e9 + 7).toInt

  def countPaths(grid: Array[Array[Int]]): Int = {
    val mem = grid.map(row => row.map(_ => -1));

    def visit(i: Int, j: Int, prevValue: Int = -1): Int = {
      if (i < 0 || i >= grid.length || j < 0 || j >= grid(i).length || grid(i)(j) <= prevValue) {
        return 0
      }

      if (mem(i)(j) != -1) {
        return mem(i)(j)
      }

      val currValue = grid(i)(j)
      val left = visit(i, j - 1, currValue)
      val right = visit(i, j + 1, currValue)
      val up = visit(i - 1, j, currValue)
      val down = visit(i + 1, j, currValue)

      mem(i)(j) = (1 + left + right + up + down) % MOD
      mem(i)(j)
    }

    var paths = 0
    for (i <- grid.indices; j <- grid(i).indices) {
      paths = (paths + visit(i, j)) % MOD
    }
    paths
  }
}
