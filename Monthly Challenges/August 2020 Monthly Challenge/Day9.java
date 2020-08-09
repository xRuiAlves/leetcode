public class Day9 {
    private static final int FRESH = 1;
    private static final int ROTTEN = 2;
    private static final int TO_ROT = 3;

    public int orangesRotting(int[][] grid) {
        boolean progress = true;
        int minutes = 0;

        while (progress) {
            progress = false;
            markToRot(grid);
            
            if (markRotten(grid)) {
                progress = true;
                ++minutes;
            }
        }

        return findFresh(grid) ? -1 : minutes;
    }

    private boolean markRotten(int[][] grid) {
        boolean progress = false;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == TO_ROT) {
                    grid[i][j] = ROTTEN;
                    progress = true;
                }
            }
        }
        
        return progress;
    }

    private void markToRot(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == ROTTEN) {
                    rot(grid, i + 1, j);
                    rot(grid, i - 1, j);
                    rot(grid, i, j+ 1);
                    rot(grid, i, j - 1);
                }
            }
        }
    }

    private boolean findFresh(int[][] grid) {
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == FRESH) {
                    return true;
                }
            }
        }

        return false;
    }

    private void rot(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return;
        }
        if (grid[i][j] == FRESH) {
            grid[i][j] = TO_ROT;
        }
    }
}
