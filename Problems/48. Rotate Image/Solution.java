class Solution {
    public void rotate(int[][] matrix) {
        int num_levels = (int) Math.floor(matrix.length/2);
        
        for (int level = 0; level < num_levels; ++level) {
            for (int i = 0; i < (matrix.length - 2*level - 1); ++i) {
                int x = level + i;
                
                int temp = matrix[level][x];
                matrix[level][x] = matrix[matrix.length - x - 1][level];
                matrix[matrix.length - x - 1][level] = matrix[matrix.length - level - 1][matrix.length - x - 1];
                matrix[matrix.length - level - 1][matrix.length - x - 1] = matrix[x][matrix.length - level - 1];
                matrix[x][matrix.length - level - 1] = temp;
            }
        }
    }
}