object Solution {
    def find(n: Int, parent: Array[Int]): Int = {
        if (parent(n) == n) n
        else find(parent(n), parent)
    }
    def union(n: Int, m: Int, parent: Array[Int]): Int = {
        val nr = find(n, parent)
        val mr = find(m, parent)
        if (nr == mr) 0
        else {
            parent(nr) = mr
            -1
        }
    }
    def numIslands(grid: Array[Array[Char]]): Int = {
        val parent = (0 until grid.length * grid(0).length).toArray
        var result = 0
        (0 until grid.length).foreach(col => {
            (0 until grid(col).length).foreach(row => {
                val x = grid(col)(row)
                val n = row + col * grid(col).length
                val left = if (row > 0) grid(col)(row-1) else '0'
                val up = if (col > 0) grid(col-1)(row) else '0'
                if (x == '1') {
                    result += 1
                    if (left == '1') result += union(n, n - 1, parent)
                    if (up == '1') result += union(n, n - grid(col).length, parent)
                }
            })
        })
        result
    }
}
