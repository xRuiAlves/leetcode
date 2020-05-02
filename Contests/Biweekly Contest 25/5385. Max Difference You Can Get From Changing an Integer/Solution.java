class Solution {
    public int maxDiff(int num) {
        int max_number = Integer.MIN_VALUE;
        int min_number = Integer.MAX_VALUE;

        for (int i = 0; i <= 9; ++i) {
            for (int j = 0; j <= 9; ++j) {
                String num_str = String.valueOf(num);
                String new_num_str = subst(num_str, i, j);
                int new_num = Integer.valueOf(new_num_str);
                new_num_str = String.valueOf(new_num);
                if (new_num_str.length() < num_str.length()) {
                    continue;
                }
                if (new_num != 0) {
                    max_number = Math.max(max_number, new_num);
                    min_number = Math.min(min_number, new_num);
                }
            }
        }

        return max_number - min_number;
    }

    private String subst(String num_str, int x, int y) {
        StringBuilder sb = new StringBuilder();

        for (char c : num_str.toCharArray()) {
            int digit = c - '0';
            sb.append(digit == x ? y : digit);
        }

        return sb.toString();
    }
}
