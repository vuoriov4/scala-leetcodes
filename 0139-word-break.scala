object Solution {
    def wordBreak(s: String, wordDict: List[String]): Boolean = {
        val memo = collection.mutable.HashMap[String, Boolean]()
        helper(s, wordDict.toSet, memo)
    }
    def helper(s: String, hs: Set[String], memo: collection.mutable.HashMap[String, Boolean]): Boolean = {
        if (memo.contains(s)) return memo(s)
        var result = false
        if (s == "" || hs.contains(s)) result = true
        else if (s.length > 0) {
            var si = s.length - 1
            while (si > 0) {
                val (left, right) = s.splitAt(si)
                if (hs.contains(left) && helper(right, hs, memo)) {
                    result = true
                    si = 0
                }
                si -= 1
            }
        }
        memo.update(s, result)
        result
    }
}
