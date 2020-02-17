class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] cache = new int[target + 1];
        Arrays.fill(cache, -1);
        return visit(nums, target, cache);
    }

    public int visit (int[] nums, int target, int[] cache) {
        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return 0;
        }
        
        if (cache[target] != -1) {
            return cache[target];
        }

        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            count += visit(nums, target - nums[i], cache);
        }

        cache[target] = count;
        return count;
    }
}