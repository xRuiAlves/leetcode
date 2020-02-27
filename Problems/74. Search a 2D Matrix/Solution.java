class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int num_iters = (int) Math.ceil(Math.log(matrix.length)/Math.log(2));
        int l = 0, r = matrix.length - 1;

        for (int i = 0; i < num_iters; ++i) {
            int m = (l + r)/2;
            if (matrix[m][0] == target) {
                return true;
            }
            if (matrix[m][0] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }

        int row = matrix[Math.max(r,0)][0] <= target ? r : l;
        l = 0;
        r = matrix[row].length - 1;

        while (l <= r) {
            int m = (l + r)/2;
            if (matrix[row][m] == target) {
                return true;
            }
            if (matrix[row][m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return false;
    }
}