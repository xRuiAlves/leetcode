import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day13 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> unmerged_intervals = new ArrayList<>(intervals.length + 1);
        boolean inserted_new_interval = false;

        for (int[] interval : intervals) {
            if (newInterval[0] <= interval[0] && !inserted_new_interval) {
                unmerged_intervals.add(newInterval);
                inserted_new_interval = true;
            }
            unmerged_intervals.add(interval);
        }
        
        if (!inserted_new_interval) {
            unmerged_intervals.add(newInterval);
        }

        List<int[]> merged_intervals = mergeIntervals(unmerged_intervals);
        int[][] res = new int[merged_intervals.size()][2];
        int i = 0;

        for (int[] interval : merged_intervals) {
            res[i++] = interval;
        }

        return res;
    }

    private List<int[]> mergeIntervals(List<int[]> intervals) {
        LinkedList<int[]> merged_intervals = new LinkedList<>();
        if (intervals.isEmpty()) {
            return merged_intervals;
        }
        merged_intervals.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); ++i) {
            int[] i1 = intervals.get(i);
            int[] i2 = merged_intervals.getLast();

            if (i1[0] <= i2[1]) {
                i2[0] = Math.min(i1[0], i2[0]);
                i2[1] = Math.max(i1[1], i2[1]);
            } else {
                merged_intervals.addLast(i1);
            }
        }

        return merged_intervals;
    }
}
