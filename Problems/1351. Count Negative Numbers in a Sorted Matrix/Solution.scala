object Solution {
  def countNegatives(grid: Array[Array[Int]]): Int = {
    countNegatives(grid, grid.length - 1, 0)
  }

  def countNegatives(grid: Array[Array[Int]], y: Int, x: Int, count: Int = 0): Int = {
    if (y < 0 || x >= grid.head.length) {
      count
    } else if (grid(y)(x) < 0) {
      countNegatives(grid, y - 1, x, count + grid.head.length - x)
    } else {
      countNegatives(grid, y, x + 1, count)
    }
  }
}
