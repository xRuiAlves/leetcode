import java.util.*;

class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> rows = new HashSet<>();

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int row : rows) {
            for (int j = 0; j < matrix[row].length; ++j) {
                matrix[row][j] = 0;
            }
        }

        for (int col : cols) {
            for (int i = 0; i < matrix.length; ++i) {
                matrix[i][col] = 0;
            }
        }
    }
}