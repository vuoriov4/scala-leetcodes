object Solution {
    def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
        for (i <- 0 until gas.length if gas(i) >= cost(i)) {
            val (j, g) = stoppingIndex(i, gas, cost)
            if (i == j) return j 
        }
        -1
    }
    def stoppingIndex(i0: Int, gas: Array[Int], cost: Array[Int]): (Int, Int) = {
        var i = i0
        var g = gas(i)
        while (i < i0 + gas.length) {
            if (g - cost(i % gas.length) < 0) return (i, g)
            g -= cost(i % gas.length)
            i += 1
            g += gas(i % gas.length)
        }
        (i0, g)
    }
}
