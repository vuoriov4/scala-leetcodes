object Solution {
    def myAtoi(s: String): Int = {
        var out = ""
        var reading = true
        var leading = true
        var leadingZeroes = false
        var i = 0
        var sign = 1
        if (s.length == 0) return 0
        while (reading && i < s.length) {
            val c = s(i)
            if (leading) {
                if (c == '+') {
                    sign = 1
                    leading = false
                    leadingZeroes = true
                } else if (c == '-') {
                    sign = -1
                    leading = false
                    leadingZeroes = true
                }
                else if (c.isDigit) {
                    leading = false
                    if (c.isDigit && c != '0') out += c
                    else leadingZeroes = true
                }
                else if (c != ' ') return 0
            }  else if (leadingZeroes) {
                if (c != '0')  {
                    leadingZeroes = false
                    if (c.isDigit) out += c
                    else {
                        reading = false
                    }
                }
                else {
                    println("I ams kipping " + c)
                }
            }  else {
                if (c.isDigit) out += c
                else  {
                    reading = false
                }
            }
            i += 1
        }
        if (out.length == 0) return 0
        println("out  =" + out)
        var sum = 0L
        var j = out.length - 1
        var e = 0
        while (j >= 0) {
            val c = out(j)
            val fact = math.pow(10, e).toInt
            val x = sign * c.toString.toLong * fact
            if (x + sum > Int.MaxValue || sign == 1 && e > 9) return Int.MaxValue
            else if (x + sum < Int.MinValue || sign == -1 && e > 9) return Int.MinValue
            else sum += x
            j -= 1
            e += 1
            println(e)
        }
        return sum.toInt
    }
}
