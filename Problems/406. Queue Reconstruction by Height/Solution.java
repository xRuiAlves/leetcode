import java.util.Arrays;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p2[1] - p1[1];
            }
            return p1[0] - p2[0];
        });

        int[][] queue = new int[people.length][];

        for (int i = 0; i < people.length; ++i) {
            int k = people[i][1] + 1;

            int queue_index;
            for (queue_index = 0; k > 0; ++queue_index) {
                if (queue[queue_index] == null) {
                    --k;
                }
            }
            
            queue[queue_index - 1] = people[i];
        }

        return queue;
    }
}
