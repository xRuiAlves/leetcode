public class Day10 {
    public int findJudge(int N, int[][] trust) {
        boolean[] cant_be_judge = new boolean[N];
        int[] num_trusters = new int[N];

        for (int i = 0; i < trust.length; ++i) {
            cant_be_judge[trust[i][0] - 1] = true;
            ++num_trusters[trust[i][1] - 1];
        }

        for (int i = 0; i < N; ++i) {
            if (num_trusters[i] == N - 1 && !cant_be_judge[i]) {
                return i + 1;
            }
        }

        return -1;
    }
}
