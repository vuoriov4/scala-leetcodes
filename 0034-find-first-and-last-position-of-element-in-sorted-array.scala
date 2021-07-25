object Solution {
    def searchRange(nums: Array[Int], target: Int): Array[Int] = {
        if (nums.length == 0) return Array[Int](-1, -1)
        val leftIndex = findLeftEdge(nums, target, 0, nums.length-1)
        val rightIndex = findRightEdge(nums, target, 0, nums.length-1)
        Array[Int](leftIndex, rightIndex)
    }
    def findLeftEdge(nums: Array[Int], target: Int, low: Int, high: Int): Int = {

        val mid = (low + high) / 2
        
        if (low == high && nums(mid) != target) {
            // not found
            -1
        }
        else if (nums(mid) == target && (low == high || mid == 0 || nums(mid-1) != target)) {
            // found it
            mid
        }
        else if (nums(mid) >= target) {
            // go left
            findLeftEdge(nums, target, low, mid)
        } else {
            // go right
            findLeftEdge(nums, target, mid + 1, high)
        }
    }
    def findRightEdge(nums: Array[Int], target: Int, low: Int, high: Int): Int = {
        
        val mid = (low + high) / 2

        if (low == high && nums(mid) != target) {
            // not found
            -1
        }
        else if (nums(mid) == target && (low == high || mid == nums.length - 1 || nums(mid+1) != target)) {
            // found it
            mid
        }
        else if (nums(mid) > target) {
            // go left
            findRightEdge(nums, target, low, mid )
        } else {
            // go right
            findRightEdge(nums, target, mid + 1, high)
        }
    }
}
