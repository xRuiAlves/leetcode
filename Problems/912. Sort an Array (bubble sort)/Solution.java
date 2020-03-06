class Solution {
    public List<Integer> sortArray(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            boolean swapped = false;
            for (int j = 0; j < nums.length - 1 - i; ++j) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }
}