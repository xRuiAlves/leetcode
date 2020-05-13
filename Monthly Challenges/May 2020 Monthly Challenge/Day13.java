public class Day13 {
    public String removeKdigits(String num, int k) {
        if (k == 0) return num;
        if (k == num.length()) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                --k;
            }
            sb.append(c);
        }

        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            --k;
        }

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
