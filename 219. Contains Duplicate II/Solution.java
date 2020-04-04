import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> visited = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int prev_occurence = visited.getOrDefault(nums[i], -1);
            visited.put(nums[i], i);

            if (prev_occurence == -1) {
                continue;
            }

            if (i - prev_occurence <= k) {
                return true;
            }
        }

        return false;
    }
}