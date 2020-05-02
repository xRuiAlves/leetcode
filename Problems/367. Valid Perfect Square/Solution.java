class Solution {
    public boolean isPerfectSquare(int num) {
        for (int i = 0; i <= 46340; i++) {
            int val = i*i;
            if (val == num) {
                return true;
            } if (val > num) {
                return false;
            }
        }
        return false;
    }
}
