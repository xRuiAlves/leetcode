class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == val) {
                boolean found = false;
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[k] != val) {
                        j = k;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return i;
                }
                nums[i] = nums[j];
                nums[j] = val;
            } else {
                j = Math.max(j , i);
            }
        }

        return nums.length;
    }
}