import java.util.HashSet;
import java.util.List;

public class Day29 {
    HashSet<Integer> visited = new HashSet<>();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        return matches(s, wordDict, 0);
    }
    
    private boolean matches(String s, List<String> wordDict, int idx) {
        if (idx == s.length()) {
            return true;
        }
        
        if (visited.contains(idx)) {
            return false;
        }
        visited.add(idx);
        
        for (String word : wordDict) {
            int next_idx = idx + word.length();
            
            if (next_idx <= s.length() && s.substring(idx, next_idx).equals(word)) {
                if (matches(s, wordDict, next_idx)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
