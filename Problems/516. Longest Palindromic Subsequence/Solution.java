import java.util.HashMap;

class Solution {
    public int longestPalindromeSubseq(String s) {
        HashMap<String, Integer> cache = new HashMap<>();
        cache.put("", 0);
        return visit(s, cache);
    }

    private int visit(String s, HashMap<String, Integer> cache) {
        int cached_val = cache.getOrDefault(s, -1);
        if (cached_val != -1) {
            return cached_val;
        }

        if (s.length() == 1) {
            cache.put(s, 1);
            return 1;
        }

        int count = 0;
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            count = 2 + visit(s.substring(1, s.length() - 1), cache);
        } else {
            count = Math.max(
                    visit(s.substring(0, s.length() - 1), cache),
                    visit(s.substring(1, s.length()), cache)
            );
        }

        cache.put(s, count);
        return count;
    }
}