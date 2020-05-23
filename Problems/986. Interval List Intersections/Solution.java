import java.util.List;
import java.util.LinkedList;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int a = 0;
        int b = 0;

        List<int[]> intervals = new LinkedList<>();

        while (a < A.length && b < B.length) {
            int[] i1 = A[a];
            int[] i2 = B[b];

            if (i1[0] > i2[1]) {
                ++b;
                continue;
            }
            if (i2[0] > i1[1]) {
                ++a;
                continue;
            }

            int[] interval = new int[2];
            interval[0] = Math.max(i1[0], i2[0]);

            if (i1[1] < i2[1]) {
                interval[1] = i1[1];
                ++a;
            } else if (i2[1] < i1[1]) {
                interval[1] = i2[1];
                ++b;
            } else {
                interval[1] = i1[1];
                ++a;
                ++b;
            }

            intervals.add(interval);
        }

        int[][] res = new int[intervals.size()][2];

        int i = 0;
        for (int[] interval : intervals) {
            res[i++] = interval;
        }

        return res;
    }
}
