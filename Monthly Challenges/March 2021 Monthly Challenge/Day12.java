import java.util.HashSet;
import java.util.Set;

public class Day12 {
    public boolean hasAllCodes(String s, int k) {
        if (k == 0) {
            return true;
        }

        Set<String> substrings = new HashSet<>();

        for (int i = 0; i <= s.length() - k; ++i) {
            substrings.add(s.substring(i, i + k));
        }

        return substrings.size() == Math.pow(2, k);
    }
}
