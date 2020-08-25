import java.util.*;

public class Day25 {
    public int mincostTickets(int[] days, int[] costs) {
        int last_day = days[days.length - 1];
        int[] dp = new int[last_day + 1];
        boolean[] traveling = new boolean[last_day + 1];

        for (int travel_day : days) {
            traveling[travel_day] = true;
        }

        dp[0] = 0;
        for (int i = 1; i <= last_day; ++i) {
            if (!traveling[i]) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + costs[0];

                if (i - 7 >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]);
                } else {
                    dp[i] = Math.min(dp[i], costs[1]);
                }

                if (i - 30 >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]);
                } else {
                    dp[i] = Math.min(dp[i], costs[2]);
                }
            }
        }

        return dp[last_day];
    }
}
