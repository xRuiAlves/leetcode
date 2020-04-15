public class Day15 {
    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] mults_left = new int[size];
        int[] mults_right = new int[size];
        int[] res = new int[size];

        mults_left[0] = nums[0];
        for (int i = 1; i < size; ++i) {
            mults_left[i] = nums[i] * mults_left[i - 1];
        }

        mults_right[size - 1] = nums[size - 1];
        for (int i = size - 2; i >= 0; --i) {
            mults_right[i] = nums[i] * mults_right[i + 1];
        }

        res[0] = mults_right[1];
        res[size - 1] = mults_left[size - 2];

        for (int i = 1; i < nums.length - 1; ++i) {
            res[i] = mults_left[i - 1] * mults_right[i + 1];
        }

        return res;
    }
}
