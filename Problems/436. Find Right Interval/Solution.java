class Solution {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, int[]> sorted_intervals = new TreeMap<>((i1, i2) -> i1 - i2);
        HashMap<String, Integer> interval_indexes = new HashMap<>(); 
        
        for (int i = 0; i < intervals.length; ++i) {
            sorted_intervals.put(intervals[i][0], intervals[i]);
            interval_indexes.put(getIntervalHash(intervals[i]), i);
        }
        
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, int[]> next_interval = sorted_intervals.ceilingEntry(intervals[i][1]);
            
            res[i] = next_interval != null
                ? interval_indexes.get(getIntervalHash(next_interval.getValue()))
                : -1;
        }
        
        return res;
    }
    
    private static String getIntervalHash(int[] interval) {
        return String.format("%d_%d", interval[0], interval[1]);
    }
}
