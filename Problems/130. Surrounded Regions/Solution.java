class Solution {
    private static final char CAPTURED = 'X';
    private static final char TARGET = 'O';
    private static final char OUT_OF_BOUNDS = ' ';
    private static final char ANALYSING = '?';
    private static final char BAD_CANDIDATE = '.';

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == TARGET) {
                    if (shouldCapture(board, i, j)) {
                        markSpot(board, i, j);
                    } else {
                        board[i][j] = BAD_CANDIDATE;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] != TARGET && board[i][j] != CAPTURED) {
                    board[i][j] = TARGET;
                }
            }
        }
    }

    private boolean shouldCapture(char[][] board, int i, int j) {
        char u = visit(board, i - 1, j);
        char d = visit(board, i + 1, j);
        char l = visit(board, i, j - 1);
        char r = visit(board, i, j + 1);

        if (isBadCell(u) || isBadCell(d) || isBadCell(l) || isBadCell(r)) {
            board[i][j] = BAD_CANDIDATE;
            return false;
        }

        board[i][j] = ANALYSING;

        if (u == TARGET && !shouldCapture(board, i - 1, j)) {
            board[i][j] = BAD_CANDIDATE;
            return false;
        }
        if (d == TARGET && !shouldCapture(board, i + 1, j)) {
            board[i][j] = BAD_CANDIDATE;
            return false;
        }
        if (l == TARGET && !shouldCapture(board, i, j - 1)) {
            board[i][j] = BAD_CANDIDATE;
            return false;
        }
        if (r == TARGET && !shouldCapture(board, i, j + 1)) {
            board[i][j] = BAD_CANDIDATE;
            return false;
        }

        return true;
    }

    private boolean isBadCell(char cell) {
        return (cell == BAD_CANDIDATE || cell == OUT_OF_BOUNDS);
    }

    private boolean isMarkableCell(char cell) {
        return (cell == TARGET || cell == ANALYSING);
    }

    private char visit(char[][] board, int i, int j) {
        return isOutOfBounds(board, i, j) ? OUT_OF_BOUNDS : board[i][j];
    }

    private boolean isOutOfBounds(char[][] board, int i, int j) {
        return (i < 0 || i >= board.length || j < 0 || j >= board[i].length);
    }

    private void markSpot(char[][] board, int i, int j) {
        if (isOutOfBounds(board, i, j) || !isMarkableCell(board[i][j])) {
            return;
        }

        board[i][j] = CAPTURED;

        markSpot(board, i - 1, j);
        markSpot(board, i + 1, j);
        markSpot(board, i, j - 1);
        markSpot(board, i, j + 1);
    }
}
