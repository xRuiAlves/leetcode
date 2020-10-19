import scala.collection.mutable

object Day19 {
    private val DOMINO_VALUES = 1 to 6
    private val FAILURE = -1

    def minDominoRotations(A: Array[Int], B: Array[Int]): Int = {
        if (A.length != B.length) return FAILURE

        val possible_flips: mutable.Set[Int] = mutable.Set() ++ DOMINO_VALUES

        for (i <- A.indices) {
            for (value <- DOMINO_VALUES) {
                if (A(i) != value && B(i) != value) possible_flips -= value
            }
        }

        var min_num_flips = Int.MaxValue
        for (value <- possible_flips) {
            var A_count = 0
            var B_count = 0

            for (i <- A.indices) {
                if (A(i) != B(i)) {
                    A_count += (if (A(i) == value) 1 else 0)
                    B_count += (if (B(i) == value) 1 else 0)
                }
            }

            val less_value_count = math.min(A_count, B_count)
            min_num_flips = math.min(min_num_flips, less_value_count)
        }

        if (min_num_flips == Int.MaxValue) -1 else min_num_flips
    }
}
