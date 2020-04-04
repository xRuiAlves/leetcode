class Solution {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int n0 = 1, n1 = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                }
                n1 = n0;
            } else if (isLetter(s.charAt(i - 1), s.charAt(i))) {
                if (s.charAt(i - 1) == '0') {
                    continue;
                }
                int temp = n0;
                n0 = n1;
                n1 += temp;
            } else {
                n0 = n1;
            }
        }

        return n1;
    }

    private boolean isLetter(char c1, char c2) {
        if (c1 == '0' || c1 == '1') {
            return true;
        } 
        return c1 == '2' && c2 <= '6';
    }
}