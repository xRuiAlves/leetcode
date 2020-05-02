import java.util.*;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new LinkedList<>();
        boolean found;

        for (int i = 0; i < candies.length; ++i) {
            found = false;
            int kid_candies = candies[i] + extraCandies;
            
            for (int j = 0; j < candies.length; ++j) {
                if (j != i) {
                    if (candies[j] > kid_candies) {
                        res.add(false);
                        found = true;
                        break;
                    }
                }
            }

            if (!found) {
                res.add(true);
            }
        }

        return res;
    }
}
