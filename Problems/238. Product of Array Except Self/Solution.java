class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int[] reverse_products = new int[nums.length];

        int curr_prod = 1;
        for (int i = 0; i < nums.length; ++i) {
            curr_prod *= nums[i];
            products[i] = curr_prod;
        }

        curr_prod = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            curr_prod *= nums[i];
            reverse_products[i] = curr_prod;
        }

        int[] res = new int[nums.length];
        res[0] = reverse_products[1];
        res[nums.length - 1] = products[nums.length - 2];

        for (int i = 1; i < nums.length - 1; ++i) {
            res[i] = products[i - 1] * reverse_products[i + 1];
        }

        return res;
    }
}