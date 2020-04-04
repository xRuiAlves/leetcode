import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> sequences = new HashMap<>();
        List<String> repeated_sequences = new LinkedList<>();

        for (int i = 0; i <= s.length() - 10; ++i) {
            String dna_sequence = s.substring(i, i + 10);

            int num_occurences = sequences.getOrDefault(dna_sequence, 0);
            if (num_occurences == 1) {
                repeated_sequences.add(dna_sequence);
            }

            sequences.put(dna_sequence, num_occurences + 1);
        }

        return repeated_sequences;
    }
}