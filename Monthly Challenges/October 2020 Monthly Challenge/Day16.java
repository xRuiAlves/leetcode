public class Day16 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] > target) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int num_iters = (int) Math.ceil(Math.log(n) / Math.log(2));
        int l = 0;
        int r = n - 1;
        for (int i = 0; i < num_iters && l < r; ++i) {
            int mid = (l + r) / 2;

            if (matrix[mid][0] == target) {
                return true;
            }
            if (matrix[mid][0] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        int row = matrix[r][0] <= target ? r : l;
        l = 0;
        r = m - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (matrix[row][mid] == target) {
                return true;
            }
            if (matrix[row][mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return false;
    }
}
