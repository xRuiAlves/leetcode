import java.util.TreeSet;

public class Day2 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 0 || t < 0) {
            return false;
        }

        TreeSet<Long> visited = new TreeSet<>();

        for (int i = 0; i < nums.length; ++i) {
            if (!visited.subSet((long) nums[i] - t, (long) nums[i] + t + 1).isEmpty()) {
                return true;
            }

            visited.add((long) nums[i]);
            if (visited.size() > k) {
                visited.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
