import java.util.Arrays;

public class Day25 {
    public int findMin(int[] nums) {
        return Arrays.stream(nums).reduce(nums[0], Math::min);
    }
}
