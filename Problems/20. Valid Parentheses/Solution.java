class Solution {
    public boolean isValid(String s) {
        List<Character> validChars = new LinkedList<>(Arrays.asList('(', ')', '[', ']', '{', '}'));
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!validChars.contains(c)) {
                return false;
            }

            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}