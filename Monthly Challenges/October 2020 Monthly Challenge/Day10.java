import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Day10 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(i -> i[0]));

        Stack<int[]> arrow_intervals = new Stack<>();
        arrow_intervals.add(points[0]);

        for (int i = 1; i < points.length; ++i) {
            int[] curr = points[i];
            int[] top = arrow_intervals.peek();

            if (curr[0] <= top[1]) {
                arrow_intervals.pop();
                arrow_intervals.add(new int[]{
                        Math.max(top[0], curr[0]),
                        Math.min(top[1], curr[1])
                });
            } else {
                arrow_intervals.add(curr);
            }
        }

        return arrow_intervals.size();
    }
}
