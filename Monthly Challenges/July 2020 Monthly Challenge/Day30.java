import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Day30 {
    HashMap<Integer, List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return findCombinations(s, 0, new HashSet<>(wordDict));
    }

    private List<String> findCombinations(String s, int idx, HashSet<String> dict) {
        List<String> curr = cache.getOrDefault(idx, null);
        if (curr != null) {
            return curr;
        }
        curr = new LinkedList<>();

        for (int i = idx + 1; i <= s.length(); ++i) {
            String substr = s.substring(idx, i);
            if (dict.contains(s.substring(idx, i))) {
                if (i == s.length()) {
                    curr.add(substr);
                } else {
                    List<String> sufixes = findCombinations(s, i, dict);
                    for (String sufix : sufixes) {
                        curr.add(substr + " " + sufix);
                    }
                }
            }
        }

        cache.put(idx, curr);
        return curr;
    }
}
