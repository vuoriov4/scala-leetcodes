object Solution {
    def convert(s: String, numRows: Int): String = {
        if (numRows == 1) return s
        val result = collection.mutable.ArrayBuffer[(Int, Int, Char)]()
        var loc = (0, 0)
        var dir = (0, 1)
        var numCols = 0
        for (c <- s) {
            result.append((loc._1, loc._2, c))
            numCols = math.max(numCols, loc._1 + 1)
            loc = (loc._1 + dir._1, loc._2 + dir._2)
            if (loc._2 == numRows - 1)  {
                dir = (1, -1)
            } else if (loc._2 == 0) {
                dir = (0, 1)
            }
        }
        var S = " " * (numCols * numRows)
        result.foreach(t => {
            val idx = t._1 + numCols * t._2
            S = S.updated(idx, t._3)
        })
        return S.filter(c => c != ' ')
    }
}
