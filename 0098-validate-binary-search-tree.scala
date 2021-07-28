/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def isValidBST(root: TreeNode): Boolean = {
        helper(root, None, None)
    }
    def helper(node: TreeNode, min: Option[Int], max: Option[Int]): Boolean = {
        if (node == null) true
        else {
            val bl = if (max.isDefined) node.value < max.get else true
            val br = if (min.isDefined) node.value > min.get else true
            bl && br && helper(node.left, min, Option(node.value)) && helper(node.right, Option(node.value), max)
        }
    }
}
