public class Day23 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) {
            return -1;
        }

        int[] diffs = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; ++i) {
            int diff = gas[i] - cost[i];
            sum += diff;
            diffs[i] = diff;
        }

        if (sum < 0) {
            return -1;
        }

        int best_idx = diffs.length - 1;
        int best_sum = diffs[best_idx];
        int curr_sum = diffs[best_idx];
        for (int i = diffs.length - 2; i >= 0; --i) {
            curr_sum += diffs[i];
            if (curr_sum > best_sum) {
                best_sum = curr_sum;
                best_idx = i;
            }
        }

        return best_idx;
    }
}
