public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long l = 1;
        long r = n;

        while (l < r) {
            long m = (l + r)/2;

            boolean is_bad = isBadVersion((int) m);

            if (is_bad) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return (int) l;
    }
}