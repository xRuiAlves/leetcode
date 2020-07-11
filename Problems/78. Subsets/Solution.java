import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sets = new LinkedList<>();
        int num_iters = (int) Math.pow(2, nums.length);
        
        for (int i = 0; i < num_iters; ++i) {
            List<Integer> set = new LinkedList<>();
            for (int j = 0; j < nums.length; ++j) {
                if ((i & (1 << j)) != 0) {
                    set.add(nums[j]);
                }
            }
            sets.add(set);
        }
        
        return sets;
    }
}
