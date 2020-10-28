import scala.collection.mutable.ListBuffer

object Day28 {
    def summaryRanges(nums: Array[Int]): List[String] = {
        if (nums.isEmpty) return List()

        val ranges = new ListBuffer[(Int, Int)]()
        var from = nums(0)
        var to = nums(0)

        for (i <- 1 until nums.length) {
            if (nums(i) == to + 1) to = nums(i)
            else {
                ranges.addOne(from, to)
                from = nums(i)
                to = nums(i)
            }
        }
        ranges.addOne(from, to)

        ranges.map(range => 
            if (range._1 == range._2) range._1.toString
            else s"${range._1}->${range._2}"
        ).toList
    }
}
