class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int res = 0;
        int M = matrix.length;
        int N = matrix[0].length;

        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                if (matrix[i][j] == 0) {
                    continue;
                }


                int left = getVal(matrix, i, j - 1);
                int diag = getVal(matrix, i - 1, j - 1);
                int up = getVal(matrix, i - 1, j);

                int square_size = 1 + Math.min(diag, Math.min(left, up));
                matrix[i][j] = square_size;

                res += square_size;
            }
        }

        return res;
    }

    private int getVal(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }
        return matrix[i][j];
    }
}
