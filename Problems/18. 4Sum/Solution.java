import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        HashSet<List<Integer>> used = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[i] != nums[j] && nums[j - 1] == nums[j]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                int partial_sum = nums[i] + nums[j];

                while (l < r) {
                    int sum = partial_sum + nums[l] + nums[r];
                    if (sum == target) {
                        List<Integer> candidate = Arrays.asList(nums[i], nums[j], nums[l], nums[r]);
                        if (!used.contains(candidate)) {
                            used.add(candidate);
                            res.add(candidate);
                        }
                        ++l;
                        --r;
                        while (l < r && nums[l] == nums[l - 1]) {
                            ++l;
                        }
                        while (l < r && r + 1 < nums.length && nums[r] == nums[r + 1]) {
                            --r;
                        }
                    } else if (sum > target) {
                        --r;
                    } else {
                        ++l;
                    }
                }
            }
        }

        return res;
    }
}