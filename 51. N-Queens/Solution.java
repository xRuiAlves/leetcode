import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] m = new char[n][n];
        for (int i = 0; i < m.length; ++i) {
            Arrays.fill(m[i], '.');
        }

        List<List<String>> res = new LinkedList<>();
        visit(m, res, 0);
        return res;
    }

    private void visit(char[][] m, List<List<String>> res, int depth) {
        if (depth == m.length) {
            List<String> solution = new LinkedList<>();
            for (char[] row : m) {
                solution.add(new String(row));
            }
            res.add(solution);
            return;
        }

        for (int j = 0; j < m[depth].length; ++j) {
            m[depth][j] = 'Q';
            if (isValid(m, depth, j)) {
                visit(m, res, depth + 1);
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