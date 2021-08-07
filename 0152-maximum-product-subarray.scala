object Solution {
    def maxProduct(nums: Array[Int]): Int = {
        var localMax = 1
        var localMin = 1
        var globalMax = Int.MinValue
        var i = 0
        while (i < nums.length) {
            if (nums(i) >= 0) {
                localMax = math.max(nums(i), localMax * nums(i))
                localMin = math.min(nums(i), localMin * nums(i))
            } else {
                val lm = math.max(nums(i), localMin * nums(i))
                localMin = math.min(nums(i), localMax * nums(i))
                localMax = lm
            } 
            globalMax = math.max(globalMax, localMax)
            i += 1
        }
        globalMax
    }
}
