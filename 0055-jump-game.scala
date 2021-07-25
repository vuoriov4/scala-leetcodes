object Solution {
    def canJump(nums: Array[Int]): Boolean = {
        var lim = 0
        var i = 0
        while (i <= lim && i < nums.length) {
            lim = math.max(lim, i + nums(i))
            i += 1
        }
        i == nums.length 
    }
}
