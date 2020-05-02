class Solution {
    public int maxProduct(int[] nums) {
        int max_prod = nums[0];

        for (int i = 0; i < nums.length; ++i) {
            int curr_prod = nums[i];
            max_prod = Math.max(max_prod, curr_prod);
            for (int j = i + 1; j < nums.length; ++j) {
                curr_prod *= nums[j];
                max_prod = Math.max(max_prod, curr_prod);
            }
        }

        return max_prod;
    }
}