object Solution {
    
    val nums = Map[Char, Int]('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)

    def romanToInt(s: String): Int = {
        var i = s.length - 1
        var result = 0
        while (i >= 0) {
            if (i > 0 && nums(s(i)) > nums(s(i-1))) {
                result += nums(s(i)) - nums((s(i-1)))
                i -= 2
            } else {
                result += nums(s(i))
                i -= 1
            }
        }
        result
    }
}
