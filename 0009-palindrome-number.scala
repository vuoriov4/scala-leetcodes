object Solution {
    def isPalindrome(x: Int): Boolean = {
        val s = x.toString
        (0 until s.length/2).find(i => s(i) != s(s.length - i - 1)).getOrElse(-1) < 0
    }
}
