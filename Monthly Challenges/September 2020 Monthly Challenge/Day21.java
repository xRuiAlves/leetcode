public class Day21 {
    private static final int NUM_TICKS = 1000;

    public boolean carPooling(int[][] trips, int capacity) {
        int[] trip_events = new int[NUM_TICKS];

        for(int[] trip : trips) {
            trip_events[trip[1]] -= trip[0];
            trip_events[trip[2]] += trip[0];
        }

        for (int i = 0; i < NUM_TICKS; ++i) {
            capacity += trip_events[i];

            if (capacity < 0) {
                return false;
            }
        }

        return true;
    }
}
