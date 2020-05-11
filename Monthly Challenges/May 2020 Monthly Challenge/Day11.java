public class Day11 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        flood(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void flood(int[][] image, int i, int j, int oldColor, int newColor) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[i].length || image[i][j] != oldColor || image[i][j] == newColor) {
            return;
        }

        image[i][j] = newColor;
        flood(image, i + 1, j, oldColor, newColor);
        flood(image, i - 1, j, oldColor, newColor);
        flood(image, i, j + 1, oldColor, newColor);
        flood(image, i, j - 1, oldColor, newColor);
    }
}
