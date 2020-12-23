object Solution {
    def rotate(matrix: Array[Array[Int]]): Unit = {
        val num_levels = math.floor(matrix.length / 2).toInt

        for (level <- 0 until num_levels) {
            for (i <- 0 until (matrix.length - 2*level - 1)) {
                val x = level + i
                val rx = matrix.length - x - 1
                val rlevel = matrix.length - level - 1

                val temp = matrix(level)(x)
                matrix(level)(x) = matrix(rx)(level)
                matrix(rx)(level) = matrix(rlevel)(rx)
                matrix(rlevel)(rx) = matrix(x)(rlevel)
                matrix(x)(rlevel) = temp
            }
        }
    }
}
