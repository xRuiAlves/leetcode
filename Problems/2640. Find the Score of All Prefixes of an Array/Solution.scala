import scala.collection.mutable.ArrayBuffer

object Solution {
    def findPrefixScore(nums: Array[Int]): Array[Long] = {
      nums.foldLeft((ArrayBuffer[Long](), 0L, 0L)) { case ((scoreArray, scoreSum, max), curr) =>
        val newMax = math.max(max, curr)
        val conversion = curr + newMax
        val newScoreSum = scoreSum + conversion
        (scoreArray += newScoreSum, newScoreSum, newMax)
      }
    }._1.toArray
}
