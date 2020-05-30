import java.util.ArrayList;
import java.util.Comparator;

public class Day30 {
    private static final class Distance {
        int[] points;
        double distance;

        public Distance(int[] points) {
            this.points = points;
            distance = points[0]*points[0] + points[1]*points[1];
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        ArrayList<Distance> distance_points = new ArrayList<>();
        int[][] res = new int[K][2];

        for (int i = 0; i < points.length; ++i) {
            distance_points.add(new Distance(points[i]));
        }

        distance_points.sort(Comparator.comparingDouble(d -> d.distance));
        
        for (int i = 0; i < K; ++i) {
            res[i] = distance_points.get(i).points;
        }
        
        return res;
    }
}
