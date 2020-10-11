import java.util.Stack;

class Solution {
    private static final char ALPHABET_START = 'a';
    private static final char ALPHABET_END = 'z';
    private static final int ALPHABET_SIZE = ALPHABET_END - ALPHABET_START + 1;
    
    public String smallestSubsequence(String s) {
        char[] string_chars = s.toCharArray();
        int[] char_counts = new int[ALPHABET_SIZE];
        boolean[] used_chars = new boolean[ALPHABET_SIZE];
        Stack<Character> order = new Stack<>();
        
        for (char c : string_chars) {
            ++char_counts[c - ALPHABET_START];
        }
        
        for (char c : string_chars) {
            int idx = c - ALPHABET_START;
            
            if (used_chars[idx]) {
                --char_counts[idx];
                continue;
            }
            
            while (!order.isEmpty() && c < order.peek() && char_counts[order.peek() - 'a'] > 0) {
                used_chars[order.pop() - 'a'] = false;
            }
            
            order.push(c);
            used_chars[idx] = true;
            --char_counts[idx];
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character c : order) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}
