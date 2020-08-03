public class Day3 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (!isAlphaNumeric(s.charAt(l))) {
                ++l;
            } else if (!isAlphaNumeric(s.charAt(r))) {
                --r;
            } else if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                ++l;
                --r;
            }
        }

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z')
            || (c >= '0' && c <= '9');
    }
}
