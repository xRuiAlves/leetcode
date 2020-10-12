public class Day12 {
    private static final char ALPHABET_START = 'a';
    private static final char ALPHABET_END = 'z';
    private static final int ALPHABET_SIZE = ALPHABET_END - ALPHABET_START + 1;
    private static final int TARGET_DIFF_COUNT = 2;

    public boolean buddyStrings(String A, String B) {

        if (A.length() != B.length()) {
            return false;
        }

        if (!A.equals(B)) {
            return have2diffChars(A, B);
        }

        return hasRepeatedChar(A);
    }

    private boolean hasRepeatedChar(String A) {
        boolean[] found_chars = new boolean[ALPHABET_SIZE];

        for (char c : A.toCharArray()) {
            int idx = c - ALPHABET_START;

            if (found_chars[idx]) {
                return true;
            }

            found_chars[idx] = true;
        }

        return false;
    }

    private boolean have2diffChars(String A, String B) {
        int[] diff_indexes = new int[TARGET_DIFF_COUNT];
        int diff_count = 0;

        for (int i = 0; i < A.length(); ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                if (diff_count == 2) {
                    return false;
                }

                diff_indexes[diff_count++] = i;
            }
        }

        return diff_count == 2
            && A.charAt(diff_indexes[0]) == B.charAt(diff_indexes[1])
            && A.charAt(diff_indexes[1]) == B.charAt(diff_indexes[0]);
    }
}
