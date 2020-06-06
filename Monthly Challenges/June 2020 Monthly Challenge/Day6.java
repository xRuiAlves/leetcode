import java.util.ArrayList;
import java.util.Arrays;

public class Day6 {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }

        ArrayList<int[]> queue = new ArrayList<>();

        Arrays.sort(people, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return p1[1] - p2[1];
            }
            return p2[0] - p1[0];
        });

        for (int[] person : people) {
            queue.add(person[1], person);
        }

        int[][] res = new int[people.length][2];
        for (int i = 0; i < queue.size(); ++i) {
            res[i] = queue.get(i);
        }

        return res;
    }
}
