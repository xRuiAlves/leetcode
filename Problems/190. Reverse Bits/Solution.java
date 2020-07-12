class Solution {
    private static final int NUM_BITS = 32;

    public int reverseBits(int n) {
        int reversed = 0;

        for (int i = 0; i < NUM_BITS; ++i) {
            int mask = (1 << i);
            boolean bit_activated = (n & mask) != 0;
            reversed |= bit_activated ? (1 << (NUM_BITS - i - 1)) : 0;
        }
        
        return reversed;
    }
}
