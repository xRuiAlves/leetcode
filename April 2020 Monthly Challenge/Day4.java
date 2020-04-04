public class Day4 {
    public void moveZeroes(int[] nums) {
        int zero_count = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                ++zero_count;
            } else {
                int temp = nums[i];
                nums[i] = nums[i - zero_count];
                nums[i - zero_count] = temp;
            }
        }
    }
}
