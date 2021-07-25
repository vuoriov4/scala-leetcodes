object Solution {
    
    def maxAreaBruteForce(height: Array[Int]): Int = {
        var result = 0
        for (i <- 0 until height.length) {
            val h0 = height(i)
            var j = i + 1
            while (j < height.length) {
                val h1 = height(j)
                val A = (j-i) * math.min(h0, h1)
                result = math.max(result,  A)
                j += 1
            }
        }    
        result
    }
    
    def maxAreaFaster(height: Array[Int]): Int = {
        var result = 0
        var i = 0
        while (i < height.length) {
            val h0 = height(i)
            if (result < (height.length - 1 - i) * h0) {
                var j = i + 1
                while (j < height.length) {
                    val h1 = height(j)
                    val A = (j-i) * math.min(h0, h1)
                    result = math.max(result,  A)
                    j += 1
                }
            } else {
                // Skip 
            }
            i += 1
        }    
        result
    }
    
    
    def maxArea(height: Array[Int]): Int = {
        maxAreaFaster(height)
    }
}
