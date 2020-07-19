class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int num_iters = Math.max(a.length(), b.length());
        int carry = 0;

        for (int i = 0; i < num_iters; ++i) {
            int b1 = getBitValue(a, i);
            int b2 = getBitValue(b, i);

            int val = b1 + b2 + carry;

            sb.append(val % 2);
            carry = val < 2 ? 0 : 1;
        }

        if (carry == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    private static int getBitValue(String s, int i) {
        return i < s.length() ? (s.charAt(s.length() - i - 1) - '0') : 0;
    }
}
