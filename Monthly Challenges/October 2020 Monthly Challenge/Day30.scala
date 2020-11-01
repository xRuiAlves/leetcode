object Day31 {
    def findNumberOfLIS(nums: Array[Int]): Int = {
        if (nums.length <= 1) return nums.length

        val sizes = new Array[Int](nums.length)
        val counts = Array.fill(nums.length)(1)

        for (j <- counts.indices; i <- 0 until j) {
            if (nums(i) < nums(j)) {
                if (sizes(i) >= sizes(j)) {
                    sizes(j) = sizes(i) + 1;
                    counts(j) = counts(i);
                } else if (sizes(i) + 1 == sizes(j)) {
                    counts(j) += counts(i);
                }
            }
        }

        val max = sizes.max
        var res = 0
        for (i <- sizes.indices) {
            if (sizes(i) == max) res += counts(i)
        }
        res
    }
}
