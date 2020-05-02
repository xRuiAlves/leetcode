class Solution {
    public int numIslands(char[][] grid) {
        int num_islands = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1') {
                    visit(grid, i, j);
                    ++num_islands;
                }
            }
        }
        return num_islands;
    }
    
    private void visit(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }
        
        grid[i][j] = 'X';
        visit(grid, i + 1, j);
        visit(grid, i - 1, j);
        visit(grid, i, j + 1);
        visit(grid, i, j - 1);
    }
}