public class Day20 {
    private int num_paths = 0;
    private int num_valid_squares = 0;

    private static final int START_SQUARE = 1;
    private static final int END_SQUARE = 2;
    private static final int EMPTY_SQUARE = 0;
    private static final int OBSTACLE_SQUARE = -1;

    public int uniquePathsIII(int[][] grid) {
        int start_i = -1;
        int start_j = -1;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == START_SQUARE) {
                    start_i = i;
                    start_j = j;
                }

                if (grid[i][j] != OBSTACLE_SQUARE) {
                    ++num_valid_squares;
                }
            }
        }

        visit(grid, start_i, start_j, 0);
        return num_paths;
    }

    private void visit(int[][] grid, int i, int j, int depth) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == OBSTACLE_SQUARE) {
            return;
        }

        int cell_value = grid[i][j];
        grid[i][j] = OBSTACLE_SQUARE;
        ++depth;

        if (cell_value == END_SQUARE) {
            if (depth == num_valid_squares) {
                ++num_paths;
            }
        } else {
            visit(grid, i + 1, j, depth);
            visit(grid, i - 1, j, depth);
            visit(grid, i, j + 1, depth);
            visit(grid, i, j - 1, depth);
        }

        grid[i][j] = cell_value;
    }
}
