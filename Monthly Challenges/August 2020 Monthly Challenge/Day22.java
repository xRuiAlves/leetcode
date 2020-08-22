import java.util.Map;
import java.util.TreeMap;

class Solution {
    private static final class Rectangle {
        public int x;
        public int y;
        public int width;
        public int height;
        public int area;

        public Rectangle(int[] coords) {
            this.x = coords[0];
            this.y = coords[1];
            this.width = coords[2] - coords[0] + 1;
            this.height = coords[3] - coords[1] + 1;
            this.area = width * height;
        }

        public int[] getPoint(int point_idx) {
            int y = this.y + (point_idx / this.width);
            int x = this.x + (point_idx % this.width);

            return new int[]{x, y};
        }
    }

    private TreeMap<Integer, Rectangle> rectangles;
    private int total_area;

    public Solution(int[][] rects) {
        this.rectangles = new TreeMap<>();
        this.total_area = 0;

        for (int[] rect_coords : rects) {
            Rectangle rect = new Rectangle(rect_coords);
            this.rectangles.put(total_area, rect);
            this.total_area += rect.area;
        }
    }

    public int[] pick() {
        int coord_idx = (int)(Math.random() * this.total_area);
        Map.Entry<Integer, Rectangle> entry = this.rectangles.floorEntry(coord_idx);
        int area_offset = entry.getKey();
        Rectangle rect = entry.getValue();
        
        return rect.getPoint(coord_idx - area_offset);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
