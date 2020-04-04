class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int old_color = image[sr][sc];
        substitute(image, old_color, newColor, sr, sc);
        return image;
    }

    private void substitute(int[][] image, int old_color, int new_color, int y, int x) {
        if (y < 0 || y >= image.length || x < 0 || x >= image[y].length || image[y][x] != old_color || image[y][x] == new_color) {
            return;
        }
        
        image[y][x] = new_color;
        substitute(image, old_color, new_color, y + 1, x);
        substitute(image, old_color, new_color, y - 1, x);
        substitute(image, old_color, new_color, y, x + 1);
        substitute(image, old_color, new_color, y, x - 1);
    }
}