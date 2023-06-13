object Solution {
  private[this] final def hash(numbers: Array[Int]): String = numbers.mkString("-")

  def equalPairs(grid: Array[Array[Int]]): Int = {
    val colHashCounts = grid.transpose.groupMapReduce(hash)(_ => 1)(_ + _).withDefaultValue(0)
    grid.map(hash).map(row => colHashCounts(row)).sum
  }
}
