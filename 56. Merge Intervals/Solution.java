import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }

        List<List<Integer>> merged_intervals = new LinkedList<>();
        Arrays.sort(intervals, (p1, p2) -> {
           if (p1[0] == p2[0]) {
               return p1[1] - p2[1];
           }
           return p1[0] - p2[0];
        });

        merged_intervals.add(Arrays.asList(intervals[0][0],intervals[0][1]));
        for (int i = 1; i < intervals.length; ++i) {
            List<Integer> top = merged_intervals.get(merged_intervals.size() - 1);
            int[] pair = intervals[i];
            if (pair[0] <= top.get(1)) {
                top.set(1, Math.max(top.get(1), pair[1]));
            } else {
                merged_intervals.add(Arrays.asList(pair[0], pair[1]));
            }
        }

        int[][] res = new int[merged_intervals.size()][2];
        for (int i = 0; i < merged_intervals.size(); ++i) {
            res[i][0] = merged_intervals.get(i).get(0);
            res[i][1] = merged_intervals.get(i).get(1);
        }

        return res;
    }
}