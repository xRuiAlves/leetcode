class Solution {
    public boolean validPalindrome(String s) {
        boolean searching_alternative = false;
        int alternative_l = -1;
        int alternative_r = -1;
        
        char[] chars = s.toCharArray();
        
        int l = 0, r = chars.length - 1;
        
        while (l < r) {
            if (chars[l] != chars[r]) {
                if (searching_alternative) {
                    return false;
                }
                if (alternative_l == -1) {
                    alternative_l = l + 1;
                    alternative_r = r;
                    --r;
                } else {
                    l = alternative_l;
                    r = alternative_r;
                    searching_alternative = true;
                }
            } else {
                ++l;
                --r;
            }
        }
        
        return true;
    }
}