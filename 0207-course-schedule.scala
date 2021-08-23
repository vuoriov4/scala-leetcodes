object Solution {
    var nodes = Set[Int]()
    var edges = Map[Int, List[Int]]()
    var visited = Set[Int]()
    def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
        prerequisites.foreach(t => {
            nodes = nodes + t(0)
            nodes = nodes + t(1)
            val out = t(0) +: edges.getOrElse(t(1), List[Int]())
            edges = edges + (t(1) -> out)
        })
        val res = !nodes.exists(x => bfs(x, Set[Int](x)))
        nodes = Set[Int]()
        edges = Map[Int, List[Int]]()
        visited = Set[Int]()
        res
    }
    def bfs(x: Int, path: Set[Int]): Boolean = {
        visited = visited + x
        val successors = edges.getOrElse(x, List[Int]())
        successors.exists(y => {
            if (path.contains(y)) true
            else if (!visited.contains(y)) bfs(y, path + y)
            else false
        })
    }
}
