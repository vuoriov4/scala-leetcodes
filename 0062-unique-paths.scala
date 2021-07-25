object Solution {
    val memo = collection.mutable.HashMap[(Int, Int), Int]()
    def uniquePaths(m: Int, n: Int): Int = {
        if (memo.contains((m, n))) memo((m, n))
        else {
            val result = 
                if (m == 1) 1 
                else (0 until n).map(i => uniquePaths(m-1, n-i)).sum
            memo.update((m, n), result)
            result
        }
    }
}
