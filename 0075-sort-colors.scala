object Solution {
    def sortColors(nums: Array[Int]): Unit = {
        if (nums.length == 1) return
        val l = nums.length
        var n0 = 0
        var n2 = 0
        var i = 0
        while (i <= nums.length - 1 - n2) {
            while (i < l-1-n2 && nums(i) == 2) {
                swap(i, l-1-n2, nums)
                n2 += 1
            }
            while (i > n0 && nums(i) == 0) {
                swap(i, n0, nums)
                n0 += 1
            }
            i += 1
        }
    }
    def swap(i: Int, j: Int, nums: Array[Int]): Unit = {
        val tmp = nums(i)
        nums(i) = nums(j)
        nums(j) = tmp
    }
}
