object Solution {
    def longestConsecutive(nums: Array[Int]): Int = {
        if (nums.length == 0) return 0
        val m = collection.mutable.SortedSet[Int]()
        nums.foreach(n => m.update(n, true))
        var result = 1
        var counter = 1
        var prev: Option[Int] = None
        m.foreach(num => {
            if (prev.isDefined && num == prev.get + 1) {
                counter += 1
                result = math.max(counter, result)
            } else {
                counter = 1
            }
            prev = Option(num)            
        })
        result
    }
}
