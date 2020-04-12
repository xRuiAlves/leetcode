import java.util.*;

class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> nums = new PriorityQueue<>((n1, n2) -> n2 - n1);
        for (int num : stones) {
            nums.add(num);
        }

        while(nums.size() > 1) {
            int stone1 = nums.poll();
            int stone2 = nums.poll();

            if (stone1 > stone2) {
                nums.add(stone1 - stone2);
            }
        }

        return nums.isEmpty() ? 0 : nums.poll();
    }
}
