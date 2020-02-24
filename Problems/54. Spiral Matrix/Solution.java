import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        if (matrix.length == 0) {
            return res;
        }
        int matrix_size = matrix.length * matrix[0].length;
        int width = matrix[0].length;
        int height = matrix.length - 1;
        char dir = 'r';
        int y = 0;
        int x = -1;

        while (res.size() < matrix_size) {
            if (dir == 'r') {
                for (int i = 0; i < width ; ++i) {
                    ++x;
                    res.add(matrix[y][x]);
                }
                --width;
                dir = 'd';
            } else if (dir == 'd') {
                for (int i = 0; i < height ; ++i) {
                    ++y;
                    res.add(matrix[y][x]);
                }
                --height;
                dir = 'l';
            } else if (dir == 'l') {
                for (int i = 0; i < width ; ++i) {
                    --x;
                    res.add(matrix[y][x]);
                }
                --width;
                dir = 'u';
            } else if (dir == 'u') {
                for (int i = 0; i < height ; ++i) {
                    --y;
                    res.add(matrix[y][x]);
                }
                --height;
                dir = 'r';
            }
        }

        return res;
    }
}