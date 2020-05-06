import java.util.*;

public class Day6 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int target = nums.length/2;

        for (int num : nums) {
            int count = counts.getOrDefault(num, 0);
            ++count;
            if (count > target) {
                return num;
            }
            counts.put(num, count);
        }
        
        return -1;
    }
}
