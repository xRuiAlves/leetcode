import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        int n = nums.length / 3;
        for (int num : nums) {
            int count = counts.getOrDefault(num, 0) + 1;
            counts.put(num, count);
            if (count == n + 1) {
                res.add(num);
            }
        }
        return res;
    }
}