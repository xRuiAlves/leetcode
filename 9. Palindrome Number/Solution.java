class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int num_digits = (int)Math.ceil(Math.log10((long)x+1));
        int d1 = 1, d2 = (int)Math.pow(10, num_digits - 1);
        for (int i = 0; i < num_digits/2; i++) {
            int a = (x / d1) % 10;
            int b = (x / d2) % 10;
            if (a != b) {
                return false;
            }
            d1 *= 10;
            d2 /= 10;
        }
        return true;
    }
}