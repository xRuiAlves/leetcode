class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; ++i) {
            int end_i = s.length - i - 1;
            char temp = s[i];
            s[i] = s[end_i];
            s[end_i] = temp;
        }
    }
}
