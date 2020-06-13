import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

public class Day13 {
    private static final int UNUSED = -1;

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new LinkedList<>();
        }

        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] indexes = new int[nums.length];

        int curr_max = 0;
        int curr_max_index = -1;

        Arrays.fill(dp, 1);
        Arrays.fill(indexes, UNUSED);

        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] + 1 > dp[i] && nums[i] % nums[j] == 0) {
                    indexes[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }

            if (curr_max < dp[i]){
                curr_max = dp[i];
                curr_max_index = i;
            }
        }

        List<Integer> res = new LinkedList<>();

        int i = curr_max_index;
        while (i != UNUSED) {
            res.add(nums[i]);
            i = indexes[i];
        }

        return res;
    }
}
