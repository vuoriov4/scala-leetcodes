object Solution {
    def rotate(matrix: Array[Array[Int]]): Unit = {
        // reverse columns
        (0 until matrix.length / 2).foreach(col => {
            (0 until matrix(col).length).foreach(row => {
                val rcol = matrix.length - col - 1
                val tmp = matrix(col)(row)
                matrix(col)(row) = matrix(rcol)(row)
                matrix(rcol)(row) = tmp
            })
        })
        // transpose
        (0 until matrix.length).foreach(col => {
            (0 until col).foreach(row => {
                val tmp = matrix(col)(row)
                matrix(col)(row) = matrix(row)(col)
                matrix(row)(col) = tmp
            })
        })
    }
}
