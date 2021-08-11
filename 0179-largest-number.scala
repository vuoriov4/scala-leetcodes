object Solution {
    def largestNumber(nums: Array[Int]): String = {
        nums.sortWith((a: Int, b: Int) => {
            (a.toString + b.toString).toLong > (b.toString + a.toString).toLong
        }).foldLeft("")((a, b) => {
            if (a == "0") b.toString else a + b.toString
        })
    }
}
