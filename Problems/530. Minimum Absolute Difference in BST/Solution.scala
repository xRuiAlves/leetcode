object Solution {
  def getMinimumDifference(node: TreeNode, lb: Long = Int.MinValue, ub: Long = Int.MaxValue): Int = node match {
    case null => Int.MaxValue
    case _ =>
      val diff = math.min(math.abs(ub - node.value), math.abs(node.value - lb))
      val leftDiff = getMinimumDifference(node.left, lb, node.value)
      val rightDiff = getMinimumDifference(node.right, node.value, ub)
      math.min(diff, math.min(leftDiff, rightDiff)).toInt
  }
}
