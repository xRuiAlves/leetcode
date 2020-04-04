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
    List<Integer> res = new LinkedList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }
        visit(root);
        return res;
    }

    private void visit(Node node) {
        for (Node child : node.children) {
            visit(child);
        }
        res.add(node.val);
    }
}