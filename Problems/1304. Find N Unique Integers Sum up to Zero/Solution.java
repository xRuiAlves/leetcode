class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];

        if (n % 2 == 1) {
            for (int i = 0, k = -(n/2); i < n; ++i) {
                res[i] = k + i;
            }
        } else {
            for (int i = 0, k = 1; i < n/2; ++i) {
                res[2*i] = k + i;
                res[2*i + 1] = -(k + i);
            }
        }

        return res;
    }
}