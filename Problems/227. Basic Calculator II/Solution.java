import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> partials = new Stack<>();
        int curr_num = 0;
        char op = ' ';

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                curr_num = curr_num*10 + (c - '0');
            } else {
                applyOp(curr_num, op, partials);
                curr_num = 0;
                op = c;
            }
        }
        applyOp(curr_num, op, partials);
        
        int res = 0;
        while (!partials.isEmpty()) {
            res += partials.pop();
        }
        
        return res;
    }

    private void applyOp(int num, char op, Stack<Integer> partials) {
        if (op == '-') {
            partials.add(-num);
        } else if (op == '*') {
            partials.add(partials.pop()*num);
        } else if (op == '/') {
            partials.add(partials.pop()/num);
        } else {
            partials.add(num);
        }
    }
}
