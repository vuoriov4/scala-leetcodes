object Solution {
    def generateParenthesis(n: Int): List[String] = {
        val result = collection.mutable.ArrayBuffer[String]()
        val pq = collection.mutable.Stack[(String, Int, Int, Int)]()
        pq.append(("(", 1, 0, 1))
        while (pq.nonEmpty) {
            val (state, numLeft, numRight, counter) = pq.pop()
            if (state.length >= n * 2) {
                if (counter == 0) result.append(state)
            } else {
                if (numLeft < n && counter >= 0) pq.append((state + "(", numLeft + 1, numRight, counter + 1))
                if (numRight < n && counter > 0) pq.append((state + ")", numLeft, numRight + 1, counter - 1))
            }
        }
        result.toList
    }
}
