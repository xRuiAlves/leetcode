import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final int UNVISITED = -2;

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> sums = new HashMap<>();
        int best = 0;
        int curr = 0;
        sums.put(0, -1);

        for (int i = 0; i < nums.length; ++i) {
            curr += nums[i] == 1 ? 1 : -1;
            
            int prev_occurence = sums.getOrDefault(curr, UNVISITED);
            if (prev_occurence != UNVISITED) {
                best = Math.max(best, i - prev_occurence);
            } else {
                sums.put(curr, i);
            }
        }

        return best;
    }
}
