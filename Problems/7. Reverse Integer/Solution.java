class Solution {
    public int reverse(int x) {
        int mult = (x >= 0) ? 1 : -1;
        long res = 0;
        x = Math.abs(x);
        while (x > 0) {
            res = (res*10) + x%10;
            x = x/10;
        }
        res *= mult;
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) ? 0 : (int)res;
    }
}