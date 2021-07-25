object Solution {

 
    case class State(id: Int, isFinal: Boolean, successors: collection.mutable.HashMap[String, State]) {
        override def toString() = {
            successors.keys.toSeq.toString
        }
    }

    def patternToState(p: String): State = {
        var currentState = State(p.length, true, collection.mutable.HashMap.empty[String, State])
        var i = p.length - 1
        while (i >= 0) {
            val c = p(i)
            if (c == '*') {
                val preceding = p(i-1)
                currentState.successors.addOne((preceding.toString + '*', currentState))
                val newState = State(i, false, collection.mutable.HashMap(("()", currentState)))
                currentState = newState
                i -= 1
            } else {
                val newState = State(i, false, collection.mutable.HashMap((c.toString, currentState)))
                currentState = newState
            }
            i -= 1
        }
        currentState
    }

    def getValidSuccessors(c: String, state: State): Seq[(String, State)] = {
        state.successors.toSeq.filter(x => {
            x._1 == "." || x._1 == c.toString || x._1 == c.toString + '*' || x._1 == ".*" || x._1 == "()"
        })
    }

    def isMatch(s: String, p: String): Boolean = {
        val stack = new collection.mutable.Stack[(Int, State)]()
        var visited = Set[(Int, Int)]()
        stack.push((0, patternToState(p)))
        while (stack.nonEmpty) {
            val (i, state) = stack.pop()
            if (state.isFinal && i == s.length) return true
            visited = visited + ((i, state.id))
            val vs = {
                if (i == s.length) state.successors.toSeq.filter(x => x._1 == "()")
                else getValidSuccessors(s(i).toString, state).filter(x => {
                    (x._1 == "()" && !visited.contains((i, x._2.id))
                    || x._1 != "()" && !visited.contains((i+1, x._2.id)))
                })
            }
            vs.reverse.foreach(x => {
                if (x._1 == "()") stack.push((i, x._2))
                else stack.push((i + 1, x._2))
            })
        }
        return false
    }
}
