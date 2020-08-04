class Solution {
    public boolean isPowerOfFour(int num) {
        for (int i = 0; i < 32; i += 2) {
            if ((num ^ (1 << i)) == 0) {
                return true;
            }
        }
        return false;
    }
}
