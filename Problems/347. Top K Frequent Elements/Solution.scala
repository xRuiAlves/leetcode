import scala.collection.mutable

object Solution {
  def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
    val frequencies = mutable.HashMap[Int, Int]().withDefaultValue(0)
    nums.foreach(num => frequencies.put(num, frequencies(num) + 1))
    frequencies
      .toArray
      .sortBy(_._2)
      .takeRight(k)
      .map(_._1)
  }
}
