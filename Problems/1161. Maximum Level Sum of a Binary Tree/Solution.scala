import scala.collection.mutable

object Solution {
  private[this] case class LevelSumPair(level: Int, sum: Int)

  def maxLevelSum(root: TreeNode): Int = {
    val toVisit = mutable.Queue[TreeNode]()
    var maxSum = LevelSumPair(1, root.value)
    var level = maxSum.level
    toVisit.enqueue(root)
    
    while (toVisit.nonEmpty) {
      var levelSum = 0

      for (_ <- toVisit.indices) {
        val curr = toVisit.dequeue()
        levelSum += curr.value
        if (curr.left != null) toVisit.enqueue(curr.left)
        if (curr.right != null) toVisit.enqueue(curr.right)
      }
      
      if (levelSum > maxSum.sum) {
        maxSum = LevelSumPair(level, levelSum)
      }

      level += 1
    }

    maxSum.level
  }
}
