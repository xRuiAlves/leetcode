import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] tokens = str.split(" ");
        if (pattern.length() != tokens.length) {
            return false;
        }

        HashMap<Character, String> symbol_table = new HashMap<>();
        for (int i = 0; i < pattern.length(); ++i) {
            String symbol_word = symbol_table.getOrDefault(pattern.charAt(i), null);

            if (symbol_word == null) {
                symbol_table.put(pattern.charAt(i), tokens[i]);
            } else {
                if (!symbol_word.equals(tokens[i])) {
                    return false;
                }
            }
        }

        Set<String> unique_symbol_words = new HashSet<>(symbol_table.values());
        return unique_symbol_words.size() == symbol_table.size();
    }
}
