import java.util.HashSet;

class Solution {
    private static final int FACTOR = 10000;

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        HashSet<Integer> visited = new HashSet<>();
        int start_color = grid[r0][c0];

        expand(grid, r0, c0, color, visited, start_color);

        return grid;
    }

    private void expand(int[][] grid, int i, int j, int color, HashSet<Integer> visited, int start_color) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != start_color || visited.contains(i*FACTOR + j)) {
            return;
        }
        visited.add(i*FACTOR + j);

        
        boolean is_border = isBorder(grid, i, j);
        
        expand(grid, i + 1, j, color, visited, start_color);
        expand(grid, i - 1, j, color, visited, start_color);
        expand(grid, i, j + 1, color, visited, start_color);
        expand(grid, i, j - 1, color, visited, start_color);
        
        if (is_border) {
            grid[i][j] = color;
        }
    }

    private boolean isBorder(int[][] grid, int i, int j) {
        int my_color = grid[i][j];

        return my_color != visitCell(grid, i + 1, j)
                || my_color != visitCell(grid, i - 1, j)
                || my_color != visitCell(grid, i, j + 1)
                || my_color != visitCell(grid, i, j - 1);
    }

    private int visitCell(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
            return -1;
        }
        return grid[i][j];
    }
}