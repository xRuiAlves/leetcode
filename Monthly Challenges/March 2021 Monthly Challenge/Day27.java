public class Day27 {
    public int countSubstrings(String s) {
        int res = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            ++res;
            int l = i, r = i;
            while (r < s.length() - 1 && s.charAt(r) == s.charAt(r + 1)) {
                ++r;
                res += (r - i + 1);
            }
            int next_index = r;

            while(l > 0 && r < s.length() - 1) {
                --l;
                ++r;
                if (s.charAt(l) != s.charAt(r)) {
                    break;
                }
                ++res;
            }

            i = next_index;
        }

        return res;
    }
}
