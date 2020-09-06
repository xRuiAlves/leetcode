class Solution {
    private int n;

    public int largestOverlap(int[][] A, int[][] B) {
        n = A.length;
        int largest_overlap = 0;

        for (int i = -n + 1; i < n; ++i) {
            for (int j = -n + 1; j < n; ++j) {
                largest_overlap = Math.max(largest_overlap, countOverlaps(A, B, i, j));
            }
        }

        return largest_overlap;
    }

    private int countOverlaps(int[][] A, int[][] B, int i_shift, int j_shift) {
        int count = 0;

        for (int i = 0; i < n; ++i) {
            if (i + i_shift < 0 || i + i_shift >= n) {
                continue;
            }

            for (int j = 0; j < n; ++j) {
                if (j + j_shift < 0 || j + j_shift >= n) {
                    continue;
                }
                
                count += A[i][j] + B[i + i_shift][j + j_shift] == 2 ? 1 : 0;
            }
        }

        return count;
    }
}
