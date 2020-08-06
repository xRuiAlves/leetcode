import java.util.LinkedList;
import java.util.List;

public class Day6 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dups = new LinkedList<>();

        for (int i = 0; i < nums.length; ++i) {
            int elem = nums[i];

            if (elem == i + 1) {
                continue;
            }
                
            if (nums[elem - 1] != elem) {
                nums[i] = nums[elem - 1];
                nums[elem - 1] = elem;

                if (nums[i] != i + 1) {
                    --i;
                }
            }
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != i + 1) {
                dups.add(nums[i]);
            }
        }

        return dups;
    }
}
