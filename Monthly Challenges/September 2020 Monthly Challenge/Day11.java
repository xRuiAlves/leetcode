public class Day11 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int curr = nums[0];

        for (int i = 1; i < nums.length; ++i) {
            curr = (curr == 0) ? nums[i] : (curr * nums[i]);
            max = Math.max(max, curr);
        }

        curr = nums[nums.length - 1];
        max = Math.max(max, curr);
        for (int i = nums.length - 2; i >= 0; --i) {
            curr = (curr == 0) ? nums[i] : (curr * nums[i]);
            max = Math.max(max, curr);
        }

        return max;
    }
}
