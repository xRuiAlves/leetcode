import java.util.*;

public class Day7 {
    public int countElements(int[] arr) {
        Map<Integer, Integer> num_counts = new HashMap<>();

        for (int num : arr) {
            num_counts.put(num, num_counts.getOrDefault(num, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : num_counts.entrySet()) {
            res += num_counts.containsKey(entry.getKey() + 1) ? entry.getValue() : 0;
        }
        
        return res;
    }
}
