class Solution {
    private static final int ALPHABET_START = '0';
    private static final int ALPHABET_END = '9';
    private static final int ALPHABET_SIZE = ALPHABET_END - ALPHABET_START + 1;

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int[] char_counts = new int[ALPHABET_SIZE];

        for (int i = 0; i < secret.length(); ++i) {
            if (secret.charAt(i) == guess.charAt(i)) {
                ++bulls;
            } else {
                ++char_counts[secret.charAt(i) - ALPHABET_START];
            }
        }

        int cows = 0;
        for (int i = 0; i < guess.length(); ++i) {
            if (secret.charAt(i) != guess.charAt(i)){
                int char_idx = guess.charAt(i) - ALPHABET_START;
                if (char_counts[char_idx] > 0) {
                    ++cows;
                    --char_counts[char_idx];
                }
            }
        }

        return String.format("%dA%dB", bulls, cows);
    }
}
