import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        int best = 0;
        int score = 0;
        Map<Integer, Integer> occurences = new HashMap<>();
        occurences.put(0, -1);

        for (int i = 0; i < nums.length; ++i) {
            score += nums[i] == 0 ? 1 : -1;

            if (occurences.containsKey(score)) {
                int last_index = occurences.get(score);
                best = Math.max(best, i - last_index);
            } else {
                occurences.put(score, i);
            }
        }
        
        return best;
    }
}
