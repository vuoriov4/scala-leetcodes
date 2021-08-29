object Solution {
    def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = {
        var row = 0
        var col = matrix(0).length - 1
        while (row < matrix.length && col >= 0) {
            val x = matrix(row)(col)
            if (x > target) col -= 1
            else if (x < target) row += 1
            else return true
        }
        false
    }
}
