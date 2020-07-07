public class Day7 {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    perimeter += cellPerimeter(grid, i, j);
                }
            }
        }

        return perimeter;
    }

    private int cellPerimeter(int[][] grid, int i, int j) {
        return (visit(grid, i + 1, j) != 1 ? 1 : 0)
                + (visit(grid, i - 1, j) != 1 ? 1 : 0)
                + (visit(grid, i, j + 1) != 1 ? 1 : 0)
                + (visit(grid, i, j - 1) != 1 ? 1 : 0);
    }

    private int visit(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return -1;
        }
        return grid[i][j];
    }
}
