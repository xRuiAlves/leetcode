import java.util.*;

public class Day11 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int h = 1; h <= n; ++h) {
            if (citations[n - h] < h) {
                return h - 1;
            }
        }
        return n;
    }
}
