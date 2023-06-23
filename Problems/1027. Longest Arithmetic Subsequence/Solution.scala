import scala.collection.mutable

object Solution {
  def longestArithSeqLength(nums: Array[Int]): Int = {
    val mem = nums.map(_ => mutable.HashMap[Int, Int]().withDefaultValue(1))
    var longestSeq = 0
    
    for (
      i <- nums.indices; 
      j <- 0 until i
    ) {
      val delta = nums(i) - nums(j)  
      mem(i)(delta) = mem(j)(delta) + 1
      longestSeq = math.max(longestSeq, mem(i)(delta))
    }
    
    longestSeq
  }
}
