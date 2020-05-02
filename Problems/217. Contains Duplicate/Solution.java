import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (visited.contains(num)) {
                return true;
            }
            visited.add(num);
        }
        return false;
    }
}