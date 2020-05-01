/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Day1 extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        boolean lval = isBadVersion(l);
        boolean rval = isBadVersion(r);

        while (true) {
            if (lval) {
                return l;
            }

            int m = l + (r - l)/2;
            boolean mval = isBadVersion(m);

            if (!mval) {
                if (l == m) {
                    return r;
                }
                l = m;
                lval = mval;
            } else {
                r = m;
                rval = mval;
            }
        }
    }
}
