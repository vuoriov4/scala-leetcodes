object Solution {
    def divide(dividend: Int, divisor: Int): Int = {
        if (divisor == 1) return dividend
        val sign = if (divisor > 0 && dividend > 0 || divisor < 0 && dividend < 0) 1 else -1
        val a = math.abs(dividend)
        val b = math.abs(divisor)
        var remainder = a
        var counter = 0
        while (remainder - b >= 0) {
            var sign = 
            remainder -= b
            if (counter + 1 < 0) return 2147483647
            counter += 1
        }     
        if (sign == 1) counter else -counter
    }
}
