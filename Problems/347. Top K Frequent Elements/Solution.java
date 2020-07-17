import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> occurrences = new HashMap<>();

        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[k];
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(occurrences.entrySet());
        Collections.sort(entries, (e1, e2) -> e2.getValue() - e1.getValue());

        for (int i = 0; i < k; ++i) {
            res[i] = entries.get(i).getKey();
        }
        
        return res;
    }
}
