import java.util.*;

class Solution {
    private int res = 0;

    public int totalNQueens(int n) {
        char[][] m = new char[n][n];
        for (int i = 0; i < m.length; ++i) {
            Arrays.fill(m[i], '.');
        }

        visit(m, 0);
        return res;
    }

    private void visit(char[][] m, int depth) {
        if (depth == m.length) {
            ++res;
            return;
        }

        for (int j = 0; j < m[depth].length; ++j) {
            m[depth][j] = 'Q';
            if (isValid(m, depth, j)) {
                visit(m, depth + 1);
            }
            m[depth][j] = '.';
        }
    }

    private boolean isValid(char[][] m, int row, int col) {
        for (int i = 0; i < row; ++i) {
            if (m[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; --i, --j) {
            if (m[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < m[i].length; --i, ++j) {
            if (m[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}