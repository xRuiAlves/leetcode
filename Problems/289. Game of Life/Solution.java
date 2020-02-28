class Solution {
    private static final int INVALID_STATE = -1;
    private static final int DYING = 0;
    private static final int LIVING = 1;
    private static final int LIVING_WILL_LIVE = 2;
    private static final int DYING_WILL_LIVE = 3;
    private static final int LIVING_WILL_DIE = 4;
    private static final int DYING_WILL_DIE = 5;

    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                visit(board, i, j);
            }
        }

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == LIVING || board[i][j] == LIVING_WILL_LIVE || board[i][j] == DYING_WILL_LIVE) {
                    board [i][j] = LIVING;
                } else {
                    board[i][j] = DYING;
                }
            }
        }
    }

    private void visit(int[][] board, int i, int j) {
        int num_living_neighbors = getNumLivingNeighbors(board, i, j);

        if (board[i][j] == DYING) {
            if (num_living_neighbors == 3) {
                board[i][j] = DYING_WILL_LIVE;
            } else {
            board[i][j] =  DYING_WILL_DIE;
            }
        } else {
            if (num_living_neighbors < 2 || num_living_neighbors > 3) {
                board[i][j] =  LIVING_WILL_DIE;
            } else {
                board[i][j] =  LIVING_WILL_LIVE;
            }
        }
    }

    private int getNumLivingNeighbors(int[][] board, int i, int j) {
        int[] neighbors = new int[]{
            cellValue(board, i + 1, j - 1),
            cellValue(board, i + 1, j),
            cellValue(board, i + 1, j + 1),
            cellValue(board, i, j - 1),
            cellValue(board, i, j + 1),
            cellValue(board, i - 1, j - 1),
            cellValue(board, i - 1, j),
            cellValue(board, i - 1, j + 1)
        };

        int res = 0;
        for (int neighbor : neighbors) {
            if (neighbor == LIVING || neighbor == LIVING_WILL_DIE || neighbor == LIVING_WILL_LIVE) {
                ++res;
            }
        }
        return res;
    }

    private int cellValue(int[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return INVALID_STATE;
        }
        return board[i][j];
    }
}