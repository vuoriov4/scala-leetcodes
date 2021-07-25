object Solution {
    def groupAnagrams(strs: Array[String]): List[List[String]] = {
        val occurences = collection.mutable.HashMap[Map[Char, Int], List[String]]()
        for (word <- strs) {
            val group = word.groupBy(_.toChar).view.mapValues(_.length).toMap
            val occurence = occurences.getOrElse(group, List[String]())
            occurences.update(group, List(word) ++ occurence)
        }
        occurences.map(_._2).toList
    }
}
