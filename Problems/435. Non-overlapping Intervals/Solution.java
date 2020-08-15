import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int1, int2) -> {
            if (int1[1] == int2[1]) {
                return int2[0] - int1[0];
            }
            return int1[1] - int2[1];
        });

        int count = 0;
        int j = 0;

        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[j][1] > intervals[i][0]) {
                ++count;
            } else {
                j = i;
            }
        }

        return count;
    }
}
