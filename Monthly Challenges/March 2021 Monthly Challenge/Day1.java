import java.util.HashSet;
import java.util.Set;

public class Day1 {
    public int distributeCandies(int[] candyType) {
        Set<Integer> uniqueCandy = new HashSet<>();

        for (int candy : candyType) {
            uniqueCandy.add(candy);
        }

        return Math.min(candyType.length / 2, uniqueCandy.size());
    }
}
