import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        if (nums.length == 0) {
            return res;
        } else if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        Integer curr_min = null;
        for (int i = 0; i < nums.length; ++i) {
            if (i == nums.length - 1) {
                if (curr_min == null) {
                    res.add(String.valueOf(nums[i]));
                } else {
                    res.add(String.format("%d->%d", curr_min, nums[i]));
                }
                break;
            }

            if (nums[i] == nums[i + 1] - 1) {
                if (curr_min == null) {
                    curr_min = nums[i];
                }
            } else {
                if (curr_min == null) {
                    res.add(String.valueOf(nums[i]));
                } else {
                    res.add(String.format("%d->%d", curr_min, nums[i]));
                }
                curr_min = null;
            }
        }

        return res;
    }
}