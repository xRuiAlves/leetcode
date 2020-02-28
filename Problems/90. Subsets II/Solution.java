import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();
        
        int num_iters = (int) Math.pow(2, nums.length);
        
        for (int i = 0; i < num_iters; ++i) {
            int val = i;
            List<Integer> curr = new LinkedList<>();
            for (int j = 0; j < nums.length && val > 0; ++j) {
                if (val % 2 == 1) {
                    curr.add(nums[j]);
                }
                val /= 2;
            }
            
            if (!visited.contains(curr)) {
                visited.add(curr);
                res.add(curr);
            }
        }
        
        return res;
    }
}