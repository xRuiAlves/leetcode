class Solution {
    public int maxProduct(String[] words) {
        int best = 0;
        int[] word_chars = getWordChars(words);

        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                if ((word_chars[i] & word_chars[j]) == 0) {
                    best = Math.max(best, words[i].length() * words[j].length());
                }
            }
        }

        return best;
    }

    private int[] getWordChars(String[] words) {
        int[] word_chars = new int[words.length];

        for (int i = 0; i < word_chars.length; ++i) {
            int mask = 0;
            for (int j = 0; j < words[i].length(); ++j) {
                mask |= 1 << (words[i].charAt(j) - 'a');
            }
            word_chars[i] = mask;
        }

        return word_chars;
    }
}