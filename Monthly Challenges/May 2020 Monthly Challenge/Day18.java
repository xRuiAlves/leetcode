public class Day18 {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        int len = s1.length();

        int[] s_counts = new int[26];
        int[] p_counts = new int[26];

        for (int i = 0; i < len; ++i) {
            ++p_counts[s1.charAt(i) - 'a'];
            ++s_counts[s2.charAt(i) - 'a'];
        }
        if (equalArrays(s_counts, p_counts)) {
            return true;
        }

        for (int i = len; i < s2.length(); ++i) {
            --s_counts[s2.charAt(i - len) - 'a'];
            ++s_counts[s2.charAt(i) - 'a'];
            if (equalArrays(s_counts, p_counts)) {
                return true;
            }
        }

        return false;
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
