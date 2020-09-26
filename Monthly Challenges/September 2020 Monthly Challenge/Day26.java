public class Day26 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int time = 0;
        if (timeSeries.length == 0) {
            return time;
        }
        
        time = duration * timeSeries.length;
        for (int i = 1; i < timeSeries.length; ++i) {
            time += Math.min(0, timeSeries[i] - timeSeries[i - 1] - duration);
        }
        
        return time;
    }
}
