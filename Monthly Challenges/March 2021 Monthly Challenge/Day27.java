import java.util.LinkedList;
import java.util.List;

public class Day27 {
    private static final char ALPHABET_START = 'a';
    private static final char ALPHABET_END = 'z';
    private static final int ALPHABET_SIZE = ALPHABET_END - ALPHABET_START + 1;

    public List<String> wordSubsets(String[] A, String[] B) {
        int[] bUnifiedCharCount = getUnifiedCharCount(B);

        List<String> res = new LinkedList<>();
        for (String s : A) {
            int[] sCharCount = countChars(s);
            if (isSubset(sCharCount, bUnifiedCharCount)) {
                res.add(s);
            }
        }
        
        return res;
    }

    private static int[] countChars(String s) {
        int[] counts = new int[ALPHABET_SIZE];

        for (char c : s.toCharArray()) {
            ++counts[c - ALPHABET_START];
        }

        return counts;
    }

    private static int[] getUnifiedCharCount(String[] arr) {
        int[] unifiedCharCount = countChars(arr[0]);

        for (int i = 1; i < arr.length; ++i) {
            int[] currCharCount = countChars(arr[i]);
            for (int j = 0; j < unifiedCharCount.length; ++j) {
                unifiedCharCount[j] = Math.max(unifiedCharCount[j], currCharCount[j]);
            }
        }

        return unifiedCharCount;
    }
    
    private static boolean isSubset(int[] charCountsA, int[] charCountsB) {
        for (int i = 0; i < charCountsA.length; ++i) {
            if (charCountsA[i] < charCountsB[i]) {
                return false;
            }
        }
        
        return true;
    }
}
