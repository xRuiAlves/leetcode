public class Day28 {
    private static final int NUM_BITS = 32;

    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int n = 1; n <= num; ++n) {
            for (int b = 0; b < NUM_BITS; ++b) {
                if ((n & (1 << b)) != 0) {
                    ++res[n];
                }
            }
        }

        return res;
    }
}
