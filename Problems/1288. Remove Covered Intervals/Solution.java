class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
           if (i1[0] == i2[0]) {
               return i2[1] - i1[1];
           }
            return i1[0] - i2[0];
        });
        
        int total = intervals.length;
        
        for (int i = 0; i < intervals.length; ++i) {
            int[] curr = intervals[i];
            
            for (int j = i + 1; j < intervals.length && intervals[j][1] <= curr[1]; ++j) {
                ++i;
                --total;
            }
        }
        
        return total;
    }
}
