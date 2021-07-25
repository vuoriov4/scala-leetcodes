import scala.collection.mutable

object Solution {
    def appendToSortedArray(nums1: mutable.Buffer[Int], value: Int): Unit = {
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
    def mergeSortedArrays(nums1: mutable.Buffer[Int], nums2: Array[Int]): Unit = {
        if (nums1.length == 0) nums2.foreach(nums1.append(_))
        nums2.foreach(appendToSortedArray(nums1, _))
    }
    def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
        val nums1Mutable = nums1.toBuffer
        mergeSortedArrays(nums1Mutable, nums2)
        val median = 0.5 * nums1Mutable((nums1Mutable.length - 1) / 2) + 0.5 * nums1Mutable((nums1Mutable.length) / 2)
        return median
    }
}

