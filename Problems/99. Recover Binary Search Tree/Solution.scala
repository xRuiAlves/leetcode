/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */

object Solution {
    var swapped = true
    def recoverTree(root: TreeNode): Unit = {
        swapped = true
        while (swapped) {
            swapped = false
            recoverTree(root, new TreeNode(Int.MinValue), new TreeNode(Int.MaxValue))
        }
    }

    def recoverTree(node: TreeNode, lb: TreeNode, ub: TreeNode): Unit = {
        if (node == null) return
        else if (node.value < lb.value) swapNodes(node, lb)
        else if (node.value > ub.value) swapNodes(node, ub)
        else {
            recoverTree(node.left, lb, node)
            recoverTree(node.right, node, ub)
        }
    }

    def swapNodes(n1: TreeNode, n2: TreeNode): Unit = {
        val temp = n1.value
        n1.value = n2.value
        n2.value = temp
        swapped = true
    }
}
