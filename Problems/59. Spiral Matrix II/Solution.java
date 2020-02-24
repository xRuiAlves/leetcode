class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }

        int x = -1, y = 0;
        int width = n, height = n - 1;
        char dir = 'r';
        int target_size = n * n;
        int curr_num = 1;

        while (curr_num <= target_size) {
            if (dir == 'r') {
                for (int i = 0; i < width; ++i) {
                    ++x;
                    matrix[y][x] = curr_num++;
                }
                --width;
                dir = 'd';
            } else if (dir == 'd') {
                for (int i = 0; i < height; ++i) {
                    ++y;
                    matrix[y][x] = curr_num++;
                }
                --height;
                dir = 'l';
            } else if (dir == 'l') {
                for (int i = 0; i < width; ++i) {
                    --x;
                    matrix[y][x] = curr_num++;
                }
                --width;
                dir = 'u';
            } else if (dir == 'u') {
                for (int i = 0; i < height; ++i) {
                    --y;
                    matrix[y][x] = curr_num++;
                }
                --height;
                dir = 'r';
            }
        }

        return matrix;
    }
}