object Solution {
    final val NUM_GLASS_ROWS = 100

    def champagneTower(poured: Int, query_row: Int, query_glass: Int): Double = {
        val glass_matrix = Array.ofDim[Double](NUM_GLASS_ROWS + 1, NUM_GLASS_ROWS + 1)
        glass_matrix(0)(0) = poured.toDouble
        math.min(fillGlasses(glass_matrix)(query_row)(query_glass), 1)
    }

    def fillGlasses(glass_matrix: Array[Array[Double]]): Array[Array[Double]] = {
        for (row <- glass_matrix.indices; idx <- 0 to row) {
            val flood_quantity = (glass_matrix(row)(idx) - 1) / 2
            if (flood_quantity > 0) {
                glass_matrix(row + 1)(idx) = flood_quantity
                glass_matrix(row + 1)(idx + 1) = flood_quantity
            }
            else return glass_matrix
        }
        glass_matrix
    }
}
