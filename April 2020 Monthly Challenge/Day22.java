import java.util.*;

public class Day22 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        
        for (int num : nums) {
            sum += num;
            count += sums.getOrDefault(sum - k, 0);
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
