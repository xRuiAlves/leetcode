import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> dp = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; ++i) {
            dp.add(0);
        }
        dp.set(0, 1);
        
        for (int i = 1; i <= rowIndex; ++i) {
            int num_iters = i / 2;

            for (int j = rowIndex; j >= 1; --j) {
                dp.set(j, dp.get(j) + dp.get(j - 1));
            }
        }

        return dp;
    }
}
