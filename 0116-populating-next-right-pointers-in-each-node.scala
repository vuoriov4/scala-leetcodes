/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var left: Node = null
 *   var right: Node = null
 *   var next: Node = null
 * }
 */

object Solution {
    def connect(root: Node): Node = {
        var nextLevel = root
        var current = root
        while (nextLevel != null) {
            nextLevel = current.left
            while (current != null) {
                if (current.left != null) current.left.next = current.right
                if (current.right != null && current.next != null) current.right.next = current.next.left
                current = current.next
            }
            current = nextLevel
        }
        root
    }
    
}
