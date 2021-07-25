object Solution {
    def letterCombinations(digits: String): List[String] = {
        val letters = Map(
            '2' -> List('a', 'b', 'c'),
            '3' -> List('d', 'e', 'f'),
            '4' -> List('g', 'h', 'i'),
            '5' -> List('j', 'k', 'l'),
            '6' -> List('m', 'n', 'o'),
            '7' -> List('p', 'q', 'r', 's'),
            '8' -> List('t', 'u', 'v'),
            '9' -> List('w', 'x', 'y', 'z')
        )
        def inner(lc: List[String], digits: String, index: Int): List[String] = {
            if (index == digits.length) return lc
            val result = letters(digits(index)).foldLeft(List[String]())((current: List[String], c: Char) => {
                current ++ lc.map(_ + c.toString)
            })
            return inner(result, digits, index + 1)
        }
        if (digits.length == 0) return List[String]()
        inner(letters(digits(0)).map(c => c.toString), digits, 1)
    }
}
