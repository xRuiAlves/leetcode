class Solution {
    public int maxPower(String s) {
        if (s.isEmpty() ) {
            return 0;
        }

        int count = 1;
        int best_count = count;
        char curr = s.charAt(0);

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == curr) {
                ++count;
                best_count = Math.max(best_count, count);
            } else {
                curr = s.charAt(i);
                count = 1;
            }
        }

        return best_count;
    }
}
