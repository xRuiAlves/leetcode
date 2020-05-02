class Solution {
    private static final class Square {
        int l;
        int r;
        int b;
        int t;
        Square(int l, int r, int b, int t) {
            this.l = l;
            this.r = r;
            this.b = b;
            this.t = t;
        }
        int getArea() {
            return (r - l)*(t - b);
        }
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int l1 = Math.min(A, C);
        int r1 = Math.max(A, C);
        int b1 = Math.min(B, D);
        int t1 = Math.max(B, D);
        int l2 = Math.min(E, G);
        int r2 = Math.max(E, G);
        int b2 = Math.min(F, H);
        int t2 = Math.max(F, H);
        Square s1 = new Square(l1, r1, b1, t1);
        Square s2 = new Square(l2, r2, b2, t2);

        int total_area = s1.getArea() + s2.getArea();
        if ((l2 > l1 && l2 > r1) || (l1 > l2 && l1 > r2) || (b1 > b2 && b1 > t2) || (b2 > b1 && b2 > t1)) {
            return total_area;
        }

        int overlap_area = getOverlapWidth(s1, s2) * getOverlapHeight(s1, s2);
        return total_area - overlap_area;
    }

    private int getOverlapWidth(Square s1, Square s2) {
        Square st1 = s1;
        Square st2 = s2;

        if (s2.l < s1.l) {
            st2 = s1;
            st1 = s2;
        }

        return Math.min(st1.r, st2.r) - st2.l;
    }

    private int getOverlapHeight(Square s1, Square s2) {
        Square st1 = s1;
        Square st2 = s2;

        if (s2.t > s1.t) {
            st2 = s1;
            st1 = s2;
        }

        return st2.t - Math.max(s1.b, s2.b);
    }
}