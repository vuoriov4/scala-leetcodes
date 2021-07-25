object Solution {
    def merge(intervals: Array[Array[Int]]): Array[Array[Int]] = {
        val result = new collection.mutable.ArrayBuffer[Array[Int]]()
        if (intervals.length == 0) return result.toArray
        val ivs = intervals.sortBy(_(0))
        var currentIv = ivs(0)
        (1 until ivs.length).foreach(i => {
            //println("IV " + ivs(i)(0) + ", " + ivs(i)(1))
            if (currentIv(1) < ivs(i)(0)) {
                // dont merge
                result.append(currentIv)
                currentIv = ivs(i)
            } else {
                // merge
                currentIv(1) = math.max(ivs(i)(1), currentIv(1))
                currentIv(0) = math.min(ivs(i)(0), currentIv(0))
            }
        })
        result.append(currentIv)
        result.toArray
    }
}
