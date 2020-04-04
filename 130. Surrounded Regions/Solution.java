class Solution {
    private boolean border_touched = false;

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 'O') {
                    border_touched = false;
                    flood(board, i, j, 'O', 'P');
                    if (!border_touched) {
                        flood(board, i, j, 'P', 'X');
                    }
                }
            }
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 'P') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void flood(char[][] board, int i, int j, char old, char change) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != old || board[i][j] == change) {
            return;
        }

        if (isBorder(board, i, j)) {
            border_touched = true;
        }

        board[i][j] = change;
        flood(board, i + 1, j, old, change);
        flood(board, i - 1, j, old, change);
        flood(board, i, j + 1, old, change);
        flood(board, i, j - 1, old, change);
    }

    private boolean isBorder(char[][] board, int i, int j) {
        return i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1;
    }
}