/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def kthSmallest(root: TreeNode, k: Int): Int = {
        val nums = collection.mutable.ArrayBuffer[Int]()
        rec(root, nums)
        nums(k-1)        
    }
    def rec(node: TreeNode, nums: collection.mutable.ArrayBuffer[Int]): Unit = {
        if (node.left != null) rec(node.left, nums)
        nums.append(node.value)
        if (node.right != null) rec(node.right, nums)
    }
}
