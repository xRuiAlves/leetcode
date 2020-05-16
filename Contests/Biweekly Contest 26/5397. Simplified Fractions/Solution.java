import java.util.*;

class Solution {
    public List<String> simplifiedFractions(int n) {
        HashSet<Double> visited = new HashSet<>();
        List<String> res = new LinkedList<>();

        for (int numerator = 1; numerator < n; ++numerator) {
            for (int denominator = 2; denominator <= n; ++denominator) {
                double val = ((double) numerator) / denominator;
                if (val < 1 && !visited.contains(val)) {
                    visited.add(val);
                    res.add(String.format("%d/%d", numerator, denominator));
                }
            }
        }

        return res;
    }
}
