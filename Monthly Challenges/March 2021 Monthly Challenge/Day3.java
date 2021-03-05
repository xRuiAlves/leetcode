import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3 {
    public int missingNumber(int[] nums) {
        Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        for (int i = 0; i < nums.length; ++i) {
            if (!numbers.contains(i)) {
                return i;
            }
        }

        return nums.length;
    }
}
