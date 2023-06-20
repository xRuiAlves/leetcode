object Solution {
  def getAverages(nums: Array[Int], k: Int): Array[Int] = {
    val windowSize = 2*k + 1
    val averages = nums.map(_ => -1)

    nums.indices.foldLeft(0L) { case (windowSum, i) =>
      val newWindowSum = windowSum + nums(i) - (if (i < windowSize) 0 else nums(i - windowSize))
      if (i >= windowSize - 1) {
        averages(i - k) = (newWindowSum / windowSize).toInt
      }
      newWindowSum
    }

    averages
  }
}
