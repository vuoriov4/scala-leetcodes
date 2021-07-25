object Solution {
    
    def permute(nums: Array[Int]): List[List[Int]] = {
        rec(nums, 0).map(_.toList).toList
    }
    
    def rec(nums: Array[Int], index: Int): Array[Array[Int]] = {
        if (index == nums.length - 1) {
            val res = Array.ofDim[Int](1, nums.length)
            res(0) = nums
            res
        }
        else {
            (index until nums.length).toArray.flatMap(j => {
                rec(swap(nums, index, j), index + 1)
            })
        }
    }
    
    def swap(num: Array[Int], i: Int, j: Int): Array[Int] = {
        val res = num.clone()
        val tmp = res(i)
        res(i) = res(j)
        res(j) = tmp
        res
    }
    
}
