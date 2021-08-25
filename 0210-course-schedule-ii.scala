object Solution {
    def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
        var result = List[Int]()
        var nodes = collection.mutable.Map[Int, Int]()
        var edges = collection.mutable.Map[Int, List[Int]]()
        val queue = collection.mutable.Queue[Int]()
        (0 until numCourses).foreach(x => {
            nodes.update(x, 0)
            edges.update(x, List[Int]())
        })
        prerequisites.foreach(t => {
            edges.update(t(1), t(0) +: edges.getOrElse(t(1), List[Int]()))
            nodes.update(t(0), 1 + nodes(t(0)))
        })
        (0 until numCourses).foreach(x => if (nodes(x) == 0) queue.enqueue(x))
        while (queue.nonEmpty) {
            val x = queue.dequeue()
            edges(x).foreach(y => {
                val indegree = nodes(y) - 1
                nodes.update(y, indegree)
                if (indegree == 0) queue.enqueue(y)
            })
            result = x +: result
        }
        if (result.length != numCourses) Array[Int]()
        else result.reverse.toArray
    }
}
