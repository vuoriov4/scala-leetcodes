object Solution {
    def longestCommonPrefix(strs: Array[String]): String = {
        if (strs.length == 0) return ""
        var result = ""
        var i = 0
        val minLength: Int = strs.map(s => s.length).reduceLeft(_ min _)
        while (i < minLength) {
            val c = strs(0)(i)
            var j = 0
            while (j < strs.length) {
                if (c != strs(j)(i)) return result
                j += 1
            }
            result += c.toString
            i += 1
        }
        result
    }
}
