/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            res.add(curr.val);
            for (int i = curr.children.size() - 1; i >= 0; --i) {
                stack.add(curr.children.get(i));
            }
        }

        return res;
    }
}