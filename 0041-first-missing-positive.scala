object Solution {
    def firstMissingPositive(nums: Array[Int]): Int = {
        var hm = Set[Int]()
        var min = Integer.MAX_VALUE
        var max = Integer.MIN_VALUE
        nums.foreach(x => {
            min = math.min(min, x)
            max = math.max(max, x)
            hm = hm + x
        })
        var i = 1
        while (i <= max) {
            if (!hm.contains(i)) return i
            i += 1
        }
        i
    }
}
