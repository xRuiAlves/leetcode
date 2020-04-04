import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> num_count : counts.entrySet()) {
            if (num_count.getValue() == 1) {
                return num_count.getKey(); 
            }
        }
        
        return -1;
    }
}