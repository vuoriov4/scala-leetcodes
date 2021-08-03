/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var next: Node = null
 *   var random: Node = null
 * }
 */

object Solution {
    def copyRandomList(head: Node): Node = {
        if (head == null) return null
        val hm = collection.mutable.HashMap[Node, Node]()
        val a0 = head
        val b0 = new Node(head.value)
        var a = a0
        var b = b0
        while (a != null) {
            hm.update(a, b)
            a = a.next
            if (a != null) b = new Node(a.value)
        }
        a = a0
        b = b0
        while (a != null) {
            if (a.next != null) b.next = hm(a.next)
            if (a.random != null) b.random = hm(a.random)
            a = a.next
            b = b.next
        }
        b0
    }
}
