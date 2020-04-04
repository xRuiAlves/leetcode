class Solution {
    public String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        
        int a, b, x=0, y=0;
        int max_len = 0;
        for (int i = 0; i < s.length(); i++) {
            int streak_count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    streak_count++;
                } else {
                    break;
                }
            }
            a = i;
            b = i + streak_count - 1;
            while (a > 0 && b < (s.length()-1) && s.charAt(a-1) == s.charAt(b+1)) {
                a--;
                b++;
            }
            if ((b - a + 1) > max_len) {
                max_len = (b - a + 1);
                x = a;
                y = b;
            }
        }
        
        return s.substring(x, y+1);
    }
}