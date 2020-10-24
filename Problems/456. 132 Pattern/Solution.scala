object Solution {
    def find132pattern(nums: Array[Int]): Boolean = {
        for (i <- nums.indices) {
            if (hasGrowingPair(nums, i)) return true
        }
        false
    }

    def hasGrowingPair(nums: Array[Int], lb: Int): Boolean = {
        var min = Int.MaxValue
        
        for (i <- (nums.length - 1) until lb by - 1) {
            if (nums(i) > nums(lb)) {
                min = math.min(min, nums(i))
                if (nums(i) > min) return true
            }
        }
        false
    }
}
