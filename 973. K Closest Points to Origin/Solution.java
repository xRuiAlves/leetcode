import java.util.*;

class Solution {
    private static final class Point {
        int x;
        int y;
        int distance;

        Point(int[] coords) {
            this.x = coords[0];
            this.y = coords[1];
            this.distance = x*x + y*y;
        }

        public int[] getCoords() {
            return new int[]{x, y};
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        Point[] points_list = new Point[points.length];
        for (int i = 0; i < points.length; ++i) {
            points_list[i] = new Point(points[i]);
        }

        Arrays.sort(points_list, (p1, p2) -> p1.distance - p2.distance);
        
        int[][] res = new int[K][];
        for (int i = 0; i < K; ++i) {
            res[i] = points_list[i].getCoords();
        }
        
        return res;
    }
}