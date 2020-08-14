import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        int pal_size = 0;
        boolean found_odd = false;
        for (int count : counts.values()) {
            if (count % 2 == 0) {
                pal_size += count;
            } else {
                pal_size += count - 1;
                found_odd = true;
            }
        }

        return pal_size + (found_odd ? 1 : 0);
    }
}
