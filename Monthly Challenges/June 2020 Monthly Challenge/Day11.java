import java.util.LinkedList;

public class Day11 {
    public void sortColors(int[] nums) {
        LinkedList<Integer> ones = new LinkedList<>();
        LinkedList<Integer> twos = new LinkedList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                if (ones.isEmpty() && twos.isEmpty()) {
                    continue;
                }
                if (ones.isEmpty()) {
                    int idx = twos.removeFirst();
                    nums[idx] = 0;
                    nums[i] = 2;
                    twos.addLast(i);
                } else if (twos.isEmpty()) {
                    int idx = ones.removeFirst();
                    nums[idx] = 0;
                    nums[i] = 1;
                    ones.addLast(i);
                } else {
                    int idx1 = ones.removeFirst();
                    nums[idx1] = 0;
                    nums[i] = 1;
                    int idx2 = twos.removeFirst();
                    nums[idx2] = 1;
                    nums[i] = 2;
                    ones.addLast(idx2);
                    twos.addLast(i);
                }
            } else if (nums[i] == 1) {
                if (twos.isEmpty()) {
                    ones.addLast(i);
                } else {
                    int idx = twos.removeFirst();
                    nums[idx] = 1;
                    nums[i] = 2;
                    twos.addLast(i);
                    ones.addLast(idx);
                }
            } else {
                twos.addLast(i);
            }
        }
    }
}
