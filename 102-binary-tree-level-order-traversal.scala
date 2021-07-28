/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
import collection.mutable.ArrayBuffer
object Solution {
    def levelOrder(root: TreeNode): List[List[Int]] = {
        var result = List[List[Int]]()
        if (root == null) return result
        val q = collection.mutable.Queue[(TreeNode, Int)]()
        q.enqueue((root, 0))
        while (q.nonEmpty) {
            val (n, d) = q.dequeue()
            if (result.length == d) result = List[Int]() :: result
            result = result.updated(0, n.value :: result(0))
            if (n.right != null) q.enqueue((n.right, d+1))
            if (n.left != null) q.enqueue((n.left, d+1))
        }
        result.reverse
    }
}
