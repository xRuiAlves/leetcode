import java.util.Set;
import java.util.HashSet;

class Solution {
    private static final int ALPHABET_SIZE = 26;
    private static final int ALPHABET_BASE = 'a';
    private static final long MODULUS = (long) Math.pow(2, 32);

    public String longestDupSubstring(String S) {
        int lower_bound = 1;
        int upper_bound = S.length();

        while (lower_bound != upper_bound) {
            int m = (lower_bound + upper_bound)/2;

            if (find(S, m) != -1) {
                lower_bound = m + 1;
            } else {
                upper_bound = m;
            }
        }

        int idx = find(S, lower_bound - 1);
        return idx != -1
            ? S.substring(idx, idx + lower_bound - 1)
            : "";
    }


    public int find(String s, int k) {
        Set<Long> set = new HashSet<>();
        long hash = 0;

        for (int i = 0; i < k; ++i) {
            hash = (hash * ALPHABET_SIZE + (s.charAt(i) - ALPHABET_BASE)) % MODULUS;
        }
        set.add(hash);

        long base = 1;
        for (int i = 0; i < k; ++i) {
            base = (base * ALPHABET_SIZE) % MODULUS;
        }

        for (int i = 1; i < s.length() - k + 1; ++i) {
            hash = getNextHash(hash, base, s, k, i);
            if (set.contains(hash)) {
                return i;
            }
            set.add(hash);
        }

        return -1;
    }

    private long getNextHash(long hash, long base, String s, int k, int pos) {
        hash = (hash * ALPHABET_SIZE - (s.charAt(pos - 1) - ALPHABET_BASE) * base % MODULUS + MODULUS) % MODULUS;
        return (hash + (s.charAt(pos - 1 + k) - ALPHABET_BASE)) % MODULUS;
    }
}
