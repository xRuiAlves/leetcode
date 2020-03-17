class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                max = Math.max(max, getSquareSize(matrix, i, j));
            }
        }
        return max*max;
    }

    private int getSquareSize(char[][] matrix, int i, int j) {
        if (matrix[i][j] != '1') {
            return 0;
        }

        int layer = 1;
        boolean is_valid = true;
        while (is_valid && (i + layer - 1 < matrix.length) && (j + layer - 1 < matrix[i].length)) {
            ++layer;
            for (int a = 0; a < layer && i + a < matrix.length; ++a) {
                for (int b = 0; b < layer && j + b < matrix[i].length; ++b) {
                    if (a == layer - 1 || b == layer - 1) {
                        if (matrix[i + a][j + b] != '1') {
                            is_valid = false;
                            break;
                        }
                    }
                }
            }
        }

        return layer - 1;
    }
}