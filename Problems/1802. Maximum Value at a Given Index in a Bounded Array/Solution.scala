object Solution {
  /**
   * Returns the summation of all positive values less than `n`
   */
  private[this] final def summation(n: Long): Long =
    if (n > 1) n * (n - 1) / 2
    else 0

  def maxValue(arrLength: Int, index: Int, maxSum: Int): Int = {
    def validateSolution(value: Int): Boolean = {
      val leftSum = summation(value) - summation(value - index)
      val rightLength = arrLength - index - 1
      val rightSum = summation(value) - summation(value - rightLength)
      value + leftSum + rightSum <= maxSum - arrLength
    }

    def maxValueBin(l: Int, r: Int): Int = if (l >= r) l else {
      val m = (l + r + 1) / 2
      if (validateSolution(m)) {
        maxValueBin(m, r)
      } else {
        maxValueBin(l, m - 1)
      }
    }

    maxValueBin(0, maxSum) + 1
  }
}
