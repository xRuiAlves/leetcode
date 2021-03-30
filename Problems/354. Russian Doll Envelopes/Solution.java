import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length < 2) {
            return envelopes.length;
        }
        
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));
        int numEnvelopes = 1;

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < envelopes.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (isEnvelopeBigger(envelopes[i], envelopes[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            numEnvelopes = Math.max(numEnvelopes, dp[i]);
        }
        
        return numEnvelopes;
    }
    
    private boolean isEnvelopeBigger(int[] e1, int[] e2) {
        return e1[0] > e2[0] && e1[1] > e2[1];
    }
}
