import java.util.*;

public class Day17 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (s.length() < p.length()) {
            return res;
        }
        
        int len = p.length();

        int[] s_counts = new int[26];
        int[] p_counts = new int[26];

        for (int i = 0; i < len; ++i) {
            ++p_counts[p.charAt(i) - 'a'];
            ++s_counts[s.charAt(i) - 'a'];
        }
        if (equalArrays(s_counts, p_counts)) {
            res.add(0);
        }

        for (int i = len; i < s.length(); ++i) {
            --s_counts[s.charAt(i - len) - 'a'];
            ++s_counts[s.charAt(i) - 'a'];
            if (equalArrays(s_counts, p_counts)) {
                res.add(i - len + 1);
            }
        }

        return res;
    }

    private boolean equalArrays(int[] a, int[] b) {
        for (int i = 0; i < a.length; ++i) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}
