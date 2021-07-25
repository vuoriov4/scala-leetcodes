object Solution {
    class SpiralIterator(matrix: Array[Array[Int]]) extends Iterator[Int] {
        val visited = collection.mutable.HashSet[(Int, Int)]()
        var dir = (0, 1)
        var pos = (0, 0)
        def rotate(dir: (Int, Int)): (Int, Int) = (dir._2, -dir._1)
        def bounded(pos: (Int, Int)) = {
            pos._1 >= 0 && pos._2 >= 0 && pos._1 < matrix.length && pos._2 < matrix(0).length
        }
        def hasNext() = hasNext(pos)
        def hasNext(pos: (Int, Int)) = {
            !visited.contains(pos) && bounded(pos)
        }
        def next() = {
            val result = matrix(pos._1)(pos._2)
            visited += pos
            if (!hasNext((pos._1 + dir._1, pos._2 + dir._2))) dir = rotate(dir)
            pos = (pos._1 + dir._1, pos._2 + dir._2)
            result
        }
    }
    def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
        new SpiralIterator(matrix).toList
    }
}
