object Solution {
    def partition(s: String): List[List[String]] = {
        if (s.length == 0) List[List[String]]()
        if (s.length == 1) List[List[String]](List(s))
        else {
            (1 to s.length).flatMap(end => {
                val x = s.slice(0, end)
                val y = s.slice(end, s.length)
                if (x == x.reverse && end == s.length) List[List[String]](List(x))
                else if (x == x.reverse) partition(y).map(p => x :: p)
                else List[List[String]]()
            }).toList
        }
    }
}
