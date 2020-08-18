import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<Integer> nums;

    public int[] numsSameConsecDiff(int N, int K) {
        this.nums = new LinkedList<>();

        if (N == 1) {
            this.nums.add(0);
        }

        for (int i = 1; i <= 9; ++i) {
            buildNum(i, N - 1, K);
        }

        return this.nums.stream().mapToInt(Integer::intValue).toArray();
    }

    private void buildNum(int num, int N, int K) {
        if (N == 0) {
            this.nums.add(num);
            return;
        }

        int digit = num % 10;
        int down_digit = digit - K;
        int up_digit = digit + K;
        if (down_digit >= 0) {
            buildNum(num * 10 + down_digit, N - 1, K);
        }
        if (K != 0 && up_digit <= 9) {
            buildNum(num * 10 + up_digit, N - 1, K);
        }
    }
}
