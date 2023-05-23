import scala.collection.mutable

class KthLargest(k: Int, nums: Array[Int]) {
  private[this] final val sortedNums = new mutable.PriorityQueue[Int]()(Ordering[Int].reverse)
  nums.foreach(add)

  def add(num: Int): Int = {
    sortedNums.enqueue(num)
    if (sortedNums.length > k) {
      sortedNums.dequeue()
    }
    sortedNums.head
  }
}
