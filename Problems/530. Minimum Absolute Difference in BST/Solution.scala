import scala.collection.mutable.ArrayBuffer

object Solution {
  def getMinimumDifference(root: TreeNode): Int = inorder(root)
    .sliding(2)
    .map {
      case ArrayBuffer(n1, n2) => n2 - n1
    }
    .min

  def inorder(node: TreeNode): ArrayBuffer[Int] = {
    val ordering = ArrayBuffer[Int]()

    def visit(node: TreeNode): Unit = if (node != null) {
      visit(node.left)
      ordering.addOne(node.value)
      visit(node.right)
    }

    visit(node)
    ordering
  }
}
