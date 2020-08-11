public class Day10 {
    private static final char ALPHABET_BASE = 'A';
    private static final int ALPHABET_SIZE = 26;
    
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(s.length() - i - 1);
            int val = c - ALPHABET_BASE + 1;
            sum += val * Math.pow(ALPHABET_SIZE, i);
        }
        return sum;
    }
}
