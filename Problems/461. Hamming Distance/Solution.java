class Solution {
    private static final int NUM_BITS = 31;
    
    public int hammingDistance(int x, int y) {
        int distance = 0;
        for (int i = 0; i < NUM_BITS; ++i) {
            int mask = (1 << i);
            if ((x & mask) != (y & mask)) {
                ++distance;
            }
        }
        return distance;
    }
}
