import java.util.LinkedList;
import java.util.List;

public class Day22 {
    public List<Integer> majorityElement(int[] nums) {
        Integer candidate1 = null;
        Integer candidate2 = null;
        int c1 = 0;
        int c2 = 0;

        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                ++c1;
            } else if (candidate2 != null && num == candidate2) {
                ++c2;
            } else if (c1 == 0) {
                candidate1 = num;
                ++c1;
            } else if (c2 == 0) {
                candidate2 = num;
                ++c2;
            } else {
                --c1;
                --c2;
            }
        }

        List<Integer> majorities = new LinkedList<>();
        int target_size = nums.length / 3;
        c1 = 0;
        c2 = 0;
        
        for (int num : nums) {
            if (num == candidate1) {
                ++c1;
            } else if (num == candidate2) {
                ++c2;
            }
        }
        
        if (c1 > target_size) {
            majorities.add(candidate1);
        }
        if (c2 > target_size) {
            majorities.add(candidate2);
        }
        
        return majorities;
    }
}
