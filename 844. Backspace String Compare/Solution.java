import java.util.*;

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return trimString(S).equals(trimString(T));
    }

    private String trimString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}