import java.util.Stack;

class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        int sum = 0;
        char op = '+';
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            boolean is_digit = Character.isDigit(c);

            if (is_digit) {
                sum = sum*10 + (c - '0');
            }

            if (!is_digit || i == s.length() - 1) {
                if (op == '+') {
                    stack.push(sum);
                } else if (op == '-') {
                    stack.push(-sum);
                } else if (op == '*') {
                    stack.push(stack.pop() * sum);
                } else if (op == '/') {
                    stack.push(stack.pop() / sum);
                }
                sum = 0;
                op = c;
            }
        }

        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}