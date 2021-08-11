object Solution {
    def rotate(nums: Array[Int], k: Int): Unit = {
        val K = k % nums.length
        val result = nums.slice(nums.length - K, nums.length) ++ nums.slice(0, nums.length - K)
        (0 until nums.length).foreach(i => nums(i) = result(i))
    }
}
