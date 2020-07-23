import java.util.*;

public class Day23 {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[2];
        int idx = 0;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                res[idx] = entry.getKey();
                ++idx;
            }
        }

        return res;
    }
}
