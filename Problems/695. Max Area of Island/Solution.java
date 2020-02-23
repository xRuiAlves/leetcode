class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    int curr_area = visit(grid, i, j);
                    max_area = Math.max(max_area, curr_area);
                }
            }
        }
        return max_area;
    }

    private int visit(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = -1;
        
        return 1 
                + visit(grid, i + 1, j) 
                + visit(grid, i - 1, j) 
                + visit(grid, i, j + 1) 
                + visit(grid, i, j - 1);
    }
}