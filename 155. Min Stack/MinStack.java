class MinStack {
    private static final class Pair {
        public int val;
        public int min;

        public Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<Pair> stack = new Stack<>();

    public void push(int x) {
        int current_min = stack.isEmpty() ? x : stack.peek().min;
        stack.push(new Pair(x, Math.min(x, current_min)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}
