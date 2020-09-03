class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i <= s.length()/2; ++i) {
            if (verifyRepeating(s, s.substring(0, i + 1))) {
                return true;
            }
        }

        return false;
    }

    private boolean verifyRepeating(String s, String substr) {
        int len = substr.length();
        boolean single_repeat = true;

        if (s.length() % len != 0) {
            return false;
        }

        for (int i = 0; i < len; ++i) {
            for (int j = len; j < s.length(); j += len) {
                single_repeat = false;
                if (s.charAt(i) != s.charAt(j + i)) {
                    return false;
                }
            }
        }

        return !single_repeat;
    }
}
