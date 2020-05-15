public class Day15 {
    public int maxSubarraySumCircular(int[] A) {
        int best = A[0];
        int curr = A[0];

        for (int i = 1; i < A.length; ++i) {
            curr = A[i] + Math.max(curr, 0);
            best = Math.max(best, curr);
        }

        int[] rhs_sums = new int[A.length];
        int[] rhs_max_sums = new int[A.length];
        rhs_sums[A.length - 1] = A[A.length - 1];
        rhs_max_sums[A.length - 1] = A[A.length - 1];
        int lhs_sum = 0;

        for (int i = A.length - 2; i >= 0; --i) {
            rhs_sums[i] = rhs_sums[i+1] + A[i];
        }
        
        for (int i = A.length - 2; i >= 0; --i) {
            rhs_max_sums[i] = Math.max(rhs_max_sums[i+1], rhs_sums[i]);
        }

        for (int i = 0; i < A.length - 2; ++i) {
            lhs_sum += A[i];
            best = Math.max(best, lhs_sum + rhs_max_sums[i+2]);
        }

        return best;
    }
}
