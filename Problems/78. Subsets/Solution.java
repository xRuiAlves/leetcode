class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int num_iters = (int) Math.pow(2, nums.length);
        
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num_iters; ++i) {
            int num = i;
            ArrayList<Integer> entry = new ArrayList<>();
            for (int j = 0; j < nums.length; ++j) {
                if (num % 2 == 1) {
                    entry.add(nums[j]);
                }
                num /= 2;
            }
            res.add(entry);
        }
        
        return res;
    }
}