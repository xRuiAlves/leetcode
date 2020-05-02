import java.util.*;

/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

public class Day21 {
    int num_iters;

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int n = dimensions.get(0);
        int m = dimensions.get(1);
        num_iters = (int) Math.ceil(Math.log(m) / Math.log(2));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int left_elem = binaryMatrix.get(i, 0);
            int right_elem = binaryMatrix.get(i, m - 1);
            int row_min_1 = findMin1(binaryMatrix, i, left_elem, right_elem, m - 1);

            if (row_min_1 == 0) {
                return 0;
            }
            if (row_min_1 == -1) {
                continue;
            }
            min = Math.min(min, row_min_1);
        }

        return min != Integer.MAX_VALUE ? min : -1;
    }

    private int findMin1(BinaryMatrix binaryMatrix, int row, int left_elem, int right_elem, int r) {
        int l = 0;

        for (int i = 0; i < num_iters && l < r; ++i) {
            if (left_elem == 1) {
                return l;
            }
            if (right_elem == 0) {
                return -1;
            }

            int m = (l + r)/2;
            int middle_elem = binaryMatrix.get(row, m);

            if (middle_elem == 1) {
                right_elem = middle_elem;
                r = m;
            } else {
                left_elem = middle_elem;
                l = m;
            }
        }
        
        if (left_elem == 1) {
            return l;
        }
        if (right_elem == 1) {
            return r;
        }

        return -1;
    }
}
