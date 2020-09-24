class Solution {
    private static final char ALPHABET_START = 'a';
    private static final char ALPHABET_END = 'z';
    private static final int ALPHABET_SIZE = ALPHABET_END - ALPHABET_START + 1;

    public char findTheDifference(String s, String t) {
        int[] chars = new int[ALPHABET_SIZE];

        for (char c : s.toCharArray()) {
            ++chars[c - ALPHABET_START];
        }
        
        for (char c : t.toCharArray()) {
            --chars[c - ALPHABET_START];
        }
        
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] != 0) {
                return (char)(ALPHABET_START + i);
            }
        }
        
        return 0;
    }
}
