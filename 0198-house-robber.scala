object Solution {
    def rob(nums: Array[Int]): Int = {
        val memo = collection.mutable.HashMap[Int, Int]()
        rec(nums, 0, memo)
    }
    def rec(nums: Array[Int], i: Int, memo: collection.mutable.HashMap[Int, Int]): Int = {
        if (memo.contains(i)) return memo(i)
        val a = if (i + 2 < nums.length) rec(nums, i + 2, memo) else 0
        val b = if (i + 1 < nums.length) rec(nums, i + 1, memo) else 0
        val res = math.max(nums(i) + a, b)
        memo.update(i, res)
        res
    }     
}
