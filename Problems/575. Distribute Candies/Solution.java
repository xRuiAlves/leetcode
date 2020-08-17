import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int distributeCandies(int[] candies) {
        return Math.min(Arrays.stream(candies).boxed().collect(Collectors.toSet()).size(), candies.length/2);
    }
}
