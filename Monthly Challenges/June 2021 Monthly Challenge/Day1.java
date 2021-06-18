public class Day1 {
    private static final int LAND = 1;
    private static final int VISITED = 2;

    public int maxAreaOfIsland(int[][] grid) {
        int maxIsland = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                maxIsland = Math.max(maxIsland, getSize(grid, i, j));
            }
        }

        return maxIsland;
    }

    private int getSize(int[][] grid, int i, int j) {
        if (!isInBounds(grid, i, j) || grid[i][j] != LAND) {
            return 0;
        }

        grid[i][j] = VISITED;
        return 1
            + getSize(grid, i + 1, j)
            + getSize(grid, i - 1, j)
            + getSize(grid, i, j + 1)
            + getSize(grid, i, j - 1);

    }

    private boolean isInBounds(int[][] grid, int i, int j) {
        return  i >= 0 && j >= 0 && i < grid.length && j < grid[i].length;
    }
}
