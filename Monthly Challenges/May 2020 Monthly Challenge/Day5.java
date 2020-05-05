public class Day5 {
    public int firstUniqChar(String s) {
        int[] char_counts = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            ++char_counts[s.charAt(i) - 'a'];
        }

        for (int i = 0; i < s.length(); ++i) {
            if (char_counts[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
