import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        int[] factorials = calcFactorials(n);
        StringBuilder sb = new StringBuilder();
        getKPermutation(n, k - 1, used, factorials, 1, sb);
        return sb.toString();
    }

    private void getKPermutation(int n, int k, boolean[] used, int[] factorials, int index, StringBuilder sb) {
        if (index == n) {
            for (int i = 0; i < used.length; ++i) {
                if (!used[i]) {
                    sb.append(i + 1);
                    return;
                }
            }
        }

        int differential = factorials[n - index];
        int num_jumps = k/differential;

        int i = 0;
        for (int nj = 0; nj < num_jumps; ++nj) {
            if (used[i]) {
                i = (i + 1) % n;
                --nj;
            } else {
                i = (i + 1) % n;
            }
        }

        while(used[i]) {
            i = (i + 1) % n;
        }

        used[i] = true;
        sb.append(i + 1);
        getKPermutation(n, k, used, factorials, index + 1, sb);
    }

    private int[] calcFactorials(int n) {
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        for (int i = 1; i <= n; ++i) {
            factorials[i] = i * factorials[i - 1];
        }
        return factorials;
    }
}