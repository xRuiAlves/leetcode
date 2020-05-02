class Solution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; ++i) {
            s = getSayCount(s);
        }
        return s;
    }

    public String getSayCount(String s) {
        StringBuilder sb = new StringBuilder();
        char curr = s.charAt(0);
        int curr_count = 1;

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                ++curr_count;
            } else {
                sb.append(curr_count).append(curr);
                curr = s.charAt(i);
                curr_count = 1;
            }
        }

        sb.append(curr_count).append(curr);
        return sb.toString();
    }
}