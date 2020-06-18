public class Day18 {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int r = n - 1;

        while(l <= r) {
            int m = (l + r)/2;

            if(citations[m] >= n - m) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return n - l;
    }
}
