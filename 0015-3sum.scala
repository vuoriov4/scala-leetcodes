object Solution {
     def threeSum(nums: Array[Int]): List[List[Int]] = {
        val numSet = nums.toSet
        val result = collection.mutable.Set[List[Int]]()
        val sortedNums = nums.sorted
        var i = 0
        while (i < nums.length - 2) {
            val x = sortedNums(i)
            if (x > 0) i = nums.length // break
            else if (i > 0 && sortedNums(i-1) == x) i += 1 // skip
            else {
                var j = i + 1
                while (j < nums.length - 1) {
                    val y = sortedNums(j)
                    if (x + y > 0) j = nums.length // break
                    var k = j + 1
                    while (k < nums.length) {
                        val z = sortedNums(k)
                        if (x + y + z == 0) result.add(List(x, y, z))
                        else if (x + y + z > 0) k = nums.length // break
                        k += 1
                    }
                    j += 1
                }
                i += 1
            }
            
        }
        result.toList
    }
}
