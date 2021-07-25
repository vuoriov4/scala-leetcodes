object Solution {
    def threeSumClosest(nums: Array[Int], target: Int): Int = {
        var result = nums(0) + nums(1) + nums(2)
        var d = math.abs(target - result)
        val sortedNums = nums.sorted
        var i = 0
        while (i < nums.length - 2) {
            val x = sortedNums(i)
            var j = i + 1
            while (j < nums.length - 1) {
                val y = sortedNums(j)
                var k = j + 1
                while (k < nums.length) {
                    val z = sortedNums(k)
                    val d2 = math.abs(target - x - y - z)
                    if (d2 < d) {
                        result = x + y + z
                        d = d2
                    }
                    k += 1
                }
                j += 1
            }
            i += 1
        }
        result
    }
}
