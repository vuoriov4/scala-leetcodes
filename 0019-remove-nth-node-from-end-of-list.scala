/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
        var len = 0
        var tmpNode = head
        while (tmpNode.next != null) {
            len += 1
            tmpNode = tmpNode.next
        }
        len += 1
        tmpNode = head
        if (len - n == 0 && head.next != null) return head.next
        else if (len - n == 0) return null
        var i = 1
        while (i < len - n) {
            tmpNode = tmpNode.next
            i += 1
        }
        if (tmpNode.next.next != null) tmpNode.next = tmpNode.next.next    
        else tmpNode.next = null
        head        
    }
}
