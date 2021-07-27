object Solution {
    def exist(board: Array[Array[Char]], word: String): Boolean = {
        (0 until board.length).foreach(col => {
            (0 until board(col).length).foreach(row => {
                if (board(col)(row) == word(0)) {
                    // println("Initials match at " + col + ", " + row)
                    if (search(board, word, col, row)) return true 
                }
            })
        })
        false
    }
    def search(board: Array[Array[Char]], word: String, col: Int, row: Int): Boolean = {
        val stack = collection.mutable.Stack[(String, List[(Int, Int)])]() // (substring, list[column, row])
        stack.push((word, List((col, row))))
        while (stack.nonEmpty) {
            val (ss, path) = stack.pop()
            val c = path(0)._1
            val r = path(0)._2
            if (ss.length == 1 && ss(0) == board(c)(r)) return true
            getAdjacents(board, c, r).foreach(t => {
                val newSS = ss.slice(1, ss.length)
                if (newSS(0) == board(t._1)(t._2) && !path.contains(t)) stack.push((newSS, t :: path))
            })
        }
        false
    }
    def getAdjacents(board: Array[Array[Char]], c: Int, r: Int): List[(Int, Int)] = {
        var result = List[(Int, Int)]()
        if (bounded(board, c+0, r+1)) result = (c+0, r+1) :: result
        if (bounded(board, c-1, r+0)) result = (c-1, r+0) :: result
        if (bounded(board, c+0, r-1)) result = (c+0, r-1) :: result
        if (bounded(board, c+1, r+0)) result = (c+1, r+0) :: result
        result
    }
    def bounded(board: Array[Array[Char]], c: Int, r: Int) = c >= 0 && c < board.length && r >= 0 && r < board(c).length 
}
