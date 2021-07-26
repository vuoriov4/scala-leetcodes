object Solution {
    def subsets(nums: Array[Int]): List[List[Int]] = {
        var result = List[List[Int]](List())
        nums.foreach(x => {
            result = powerset(result, x)
        })
        result
    }
    def powerset(p0: List[List[Int]], p1: Int) = {
        p0 ++ p0.map(x => p1 :: x)
    }
}
