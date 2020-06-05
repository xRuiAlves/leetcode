import java.util.HashMap;
import java.util.TreeSet;

class Solution {
    private int total_sum = 0;
    private TreeSet<Integer> aggregated_frequencies;
    private HashMap<Integer, Integer> number_frequencies;

    public Solution(int[] w) {
        aggregated_frequencies = new TreeSet<>();
        number_frequencies = new HashMap<>();

        for (int i = 0; i < w.length; ++i) {
            aggregated_frequencies.add(total_sum);
            number_frequencies.put(total_sum, i);
            total_sum += w[i];
        }
    }

    public int pickIndex() {
        int random = (int)(Math.random() * total_sum);
        int base_frequency = aggregated_frequencies.floor(random);
        return number_frequencies.get(base_frequency);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
 