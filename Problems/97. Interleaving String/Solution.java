public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] cache = new boolean[s1.length()][s2.length()];

        return isInterleave(s1, s2, s3, 0, 0, cache);
    }

    private boolean isInterleave(String s1, String s2, String s3, int i, int j, boolean[][] cache) {
        if (i + j == s3.length()) {
            return true;
        }

        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(i + j));
        }

        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(i + j));
        }

        if (cache[i][j]) {
            return false;
        }

        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            if (isInterleave(s1, s2, s3, i + 1, j, cache)) {
                return true;
            }
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            if (isInterleave(s1, s2, s3, i, j + 1, cache)) {
                return true;
            }
        }

        cache[i][j] = true;
        return false;
    }
}
