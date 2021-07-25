/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {

    class MyListNode(ln: ListNode) extends Iterator[Int] {
        var currentNode = new ListNode(0, ln)
        def hasNext = currentNode.next != null
        def next() = {
            currentNode = currentNode.next
            currentNode.x
        }
    }

    def append(nums1: collection.mutable.Buffer[Int], value: Int): Unit = {
        if (nums1.length == 0) {
            nums1.insert(0, value)
            return
        }
        var startIndex = 0
        var endIndex = nums1.length - 1
        var midPoint = (startIndex + endIndex) / 2
        while (endIndex - startIndex > 1) {
            if (nums1(midPoint) > value) endIndex = midPoint
            else if (nums1(midPoint) < value) startIndex = midPoint
            else { endIndex = midPoint; startIndex = midPoint }
            midPoint = (startIndex + endIndex) / 2
        }
        if (value <= nums1(startIndex)) nums1.insert(startIndex, value)
        else if (value < nums1(endIndex)) nums1.insert(endIndex, value)
        else nums1.insert(endIndex+1, value)
    }
    def merge(nums1: collection.mutable.Buffer[Int], nums2: MyListNode): Unit = {
        nums2.foreach(append(nums1, _))
    }

    def bufferToListNode(result: collection.mutable.Buffer[Int]): ListNode = {
        if (result.length == 0) return null
        var resultNode = new ListNode(result.last)
        for (i <- 1 until result.length) resultNode = new ListNode(result(result.length - 1 - i), resultNode)
        resultNode
    }

    def mergeKLists(lists: Array[ListNode]): ListNode = {
        if (lists.length == 0) return null
        val result = new MyListNode(lists(0)).toBuffer
        for (i <- 1 until lists.length) merge(result, new MyListNode(lists(i)))
        bufferToListNode(result)
    }

}
