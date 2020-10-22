/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

object Solution {
    def minDepth(root: TreeNode): Int = if (root == null) 0 else minDepth(root, 1)

    def minDepth(node: TreeNode, depth: Int): Int = (node.left, node.right) match {
        case (null, null) => depth
        case (left, null) => minDepth(left, depth + 1)
        case (null, right) => minDepth(right, depth + 1)
        case (left, right) => math.min(
            minDepth(left, 1 + depth),
            minDepth(right, 1 + depth)
        )
    }
}
