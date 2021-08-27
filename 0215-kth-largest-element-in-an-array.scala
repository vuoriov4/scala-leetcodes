object Solution {
    def findKthLargest(nums: Array[Int], k: Int): Int = {
        val heap = collection.mutable.PriorityQueue[Int]()(Ordering[Int].reverse)
        nums.foreach(x => {
            if (heap.size < k) heap.enqueue(x)
            else if (x > heap.head) {
                heap.dequeue()
                heap.enqueue(x)
            }
        })
        heap.head
    }
}
