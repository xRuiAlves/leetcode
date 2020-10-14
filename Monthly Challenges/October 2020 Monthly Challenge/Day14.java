public class Day14 {
    Integer[] cache;

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        
        cache = new Integer[nums.length];
        int profit = rob(nums, 0, nums.length - 2);

        cache = new  Integer[nums.length];
        profit = Math.max(profit, rob(nums, 1, nums.length - 1));

        return profit;
    }

    private int rob(int[] nums, int curr_day, int last_day) {
        if (curr_day > last_day) {
            return 0;
        }

        if (cache[curr_day] == null) {
            cache[curr_day] = Math.max(
                nums[curr_day] + rob(nums, curr_day + 2, last_day),
                rob(nums, curr_day + 1, last_day)
            );
        }

        return cache[curr_day];
    }
}
