object Solution {
    
    def helper(c0: Char, c1: Char, c2: Char, digit: Int): String = {
        var result: String = ""
        assert(digit < 10 && digit >= 0)
        if (digit == 9) result += (c2.toString + c0.toString)
        else if (digit >= 5) result += (c1.toString + c2.toString * (digit - 5))
        else if (digit == 4) result += (c2.toString + c1.toString)
        else result += (c2.toString * digit)
        result
    }
    def intToRoman(num: Int): String = {
        var result = ""

        val ks = (num / 1000)
        result += "M" * ks
        
        val hs = ((num - 1000 * ks) / 100)
        result += helper('M', 'D', 'C', hs)
            
        val ts = ((num - 1000 * ks - 100 * hs) / 10)
        result += helper('C', 'L', 'X', ts)
        
        val s  = ((num - 1000 * ks - 100 * hs - 10 * ts) / 1)
        result += helper('X', 'V', 'I', s)

        result
    }
}

