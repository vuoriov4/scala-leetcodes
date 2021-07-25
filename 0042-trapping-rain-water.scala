object Solution {

    def amountWater(index: Int, height: Array[Int]): Int = {
        var k = index
        var leftMax = height(k)
        // scan left
        while (k >= 0) {
            leftMax = math.max(leftMax, height(k))
            k -= 1
        }
        // scan right
        k = index
        var rightMax = height(index)
        while (k < height.length) {
            rightMax = math.max(rightMax, height(k))
            k += 1
        }
        val h1 = math.min(leftMax, rightMax)
        math.max(0, h1 - height(index))
    }

    def trap(height: Array[Int]): Int = {
        (0 until height.length).map(i => amountWater(i, height)).sum
    }
}
