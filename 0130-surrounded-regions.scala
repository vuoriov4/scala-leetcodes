object Solution {
    def solve(board: Array[Array[Char]]): Unit = {
        for (col <- 0 until board.length; row <- 0 until board(0).length) {
            if (border(board, col, row) && board(col)(row) == 'O') {
                mark(board, col, row, true)                
            }
        }
        for (col <- 0 until board.length; row <- 0 until board(0).length) {
            if (!border(board, col, row) && board(col)(row) == 'O') {
                board(col)(row) = 'X'
            }
            else if (board(col)(row) == '*') board(col)(row) = 'O'
        }
    }
    def mark(board: Array[Array[Char]], col: Int, row: Int, initial: Boolean): Unit = {
        if (initial || (!border(board, col, row) && board(col)(row) == 'O')) {
            if (!initial) board(col)(row) = '*'
            mark(board, col - 1, row, false)
            mark(board, col + 1, row, false)
            mark(board, col, row - 1, false)
            mark(board, col, row + 1, false)
        }
    }
    def border(board: Array[Array[Char]], col: Int, row: Int): Boolean = {
        (col <= 0 || col >= board.length - 1) || (row <= 0 || row >= board(0).length - 1)
    }
}
