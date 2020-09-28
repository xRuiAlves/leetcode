oublic class Day28 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int count = 0;
        int lb = 0;
        int prod = 1;

        for (int rb = 0; rb < nums.length; ++rb) {
            prod *= nums[rb];

            while (prod >= k) {
                prod /= nums[lb++];
            }

            count += rb - lb + 1;
        }

        return count;
    }
}
