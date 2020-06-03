import java.util.Arrays;

class Solution {
    private static final class TripInfo {
        int diff;
        int[] costs;

        public TripInfo(int[] costs) {
            this.diff = Math.abs(costs[1] - costs[0]);
            this.costs = costs;
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length / 2;
        TripInfo[] trip_infos = new TripInfo[costs.length];

        for (int i = 0; i < costs.length; ++i) {
            trip_infos[i] = new TripInfo(costs[i]);
        }

        Arrays.sort(trip_infos, (t1, t2) -> t2.diff - t1.diff);

        int a_count = 0;
        int b_count = 0;
        int res = 0;

        for (TripInfo t : trip_infos) {
            if (a_count == n) {
                res += t.costs[1];
            } else if (b_count == n) {
                res += t.costs[0];
            } else {
                if (t.costs[0] < t.costs[1]) {
                    ++a_count;
                    res += t.costs[0];
                } else {
                    ++b_count;
                    res += t.costs[1];
                }
            }
        }
        
        return res;
    }
}
