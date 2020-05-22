import java.util.Arrays;

class Solution {
    private static final int NUM_CHARS = 256;

    private static final class CharCount {
        public char character;
        public int count;

        public CharCount(char character) {
            this.character = character;
            this.count = 0;
        }
    }

    public String frequencySort(String s) {
        CharCount[] char_counts = new CharCount[256];

        for (int i = 0; i < NUM_CHARS; ++i) {
            char_counts[i] = new CharCount((char) i);
        }

        for (char c : s.toCharArray()) {
            ++char_counts[c].count;
        }

        Arrays.sort(char_counts, (cc1, cc2) -> cc2.count - cc1.count);

        StringBuilder sb = new StringBuilder();

        for (CharCount cc : char_counts) {
            for (int i = 0; i < cc.count; ++i) {
                sb.append(cc.character);
            }
        }

        return sb.toString();
    }
}
