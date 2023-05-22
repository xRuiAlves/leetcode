import scala.collection.mutable

object Solution {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = nums
    .groupMapReduce(identity)(_ => 1)(_ + _)
    .toArray
    .sortBy(_._2)
    .takeRight(k)
    .map(_._1)
}
