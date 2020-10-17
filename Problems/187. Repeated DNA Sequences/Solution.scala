import scala.collection.mutable

object Solution {
    val SEQUENCE_SIZE : Int = 10

    def findRepeatedDnaSequences(s: String): List[String] = {
        val sequence_counts = new mutable.HashMap[String, Int]()

        for (i <- 0 to (s.length - SEQUENCE_SIZE)) {
            val sequence : String = s.substring(i, i + SEQUENCE_SIZE)
            sequence_counts(sequence) = sequence_counts.getOrElse(sequence, 0) + 1
        }

        sequence_counts.filter(_._2 > 1).keys.toList
    }
}
