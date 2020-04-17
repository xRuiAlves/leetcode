public class Day17 {
    private static final char WATER = '0';
    private static final char ISLAND = '1';
    
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == ISLAND) {
                    visit(grid, i, j);
                    ++count;
                }
            }
        }
        
        return count;
    }
    
    private void visit(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != ISLAND) {
            return;
        }
        
        grid[i][j] = WATER;
        visit(grid, i + 1, j);
        visit(grid, i - 1, j);
        visit(grid, i, j + 1);
        visit(grid, i, j - 1);
    }
}
