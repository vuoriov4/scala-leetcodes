object Solution {
    def productExceptSelf(nums: Array[Int]): Array[Int] = {
        var res = Array.fill[Int](nums.length)(1)
        var left = 1
        var right = 1
        for (i <- 0 until nums.length) {
            res(i) *= left 
            res(nums.length - i - 1) *= right
            left *= nums(i)
            right *= nums(nums.length - i - 1) 
        }
        res
    }
}
