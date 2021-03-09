public class Day1 {
    private static final int NUM_BITS = 32;
    
    public int hammingWeight(int n) {
        int count = n >= 0 ? 0 : 1;
        int input = n >= 0 ? n : (n ^ (1 << (NUM_BITS - 1)));

        while (input != 0) {
            count += (input & 1);
            input >>= 1;
        }

        return count;
    }
}
