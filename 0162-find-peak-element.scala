object Solution {
    def findPeakElement(nums: Array[Int]): Int = {
        rec(nums, 0, nums.length - 1)
    }
    def rec(nums: Array[Int], start: Int, end: Int): Int = {
        val mid = (start + end) / 2
        val isPeak =  (mid == 0 || nums(mid-1) < nums(mid)) && (mid == nums.length - 1 || nums(mid+1) < nums(mid))
        val left = mid > 0 && nums(mid-1) > nums(mid)
        if (isPeak) mid
        else if (left) rec(nums, start, mid)
        else rec(nums, mid+1, end)
    }
}
