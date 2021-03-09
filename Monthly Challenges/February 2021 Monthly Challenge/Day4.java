import java.util.*;

public class Day4 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> harmonics = new HashMap<>();
        Set<Integer> existingNumbers = new HashSet<>();

        for (int num : nums) {
            existingNumbers.add(num);
            harmonics.put(num, harmonics.getOrDefault(num, 0) + 1);
            harmonics.put(num - 1, harmonics.getOrDefault(num - 1, 0) + 1);
        }

        return harmonics
            .entrySet()
            .stream()
            .filter(kv -> existingNumbers.contains(kv.getKey()) && existingNumbers.contains(kv.getKey() + 1))
            .mapToInt(Map.Entry::getValue)
            .max()
            .orElse(0);
    }
}
