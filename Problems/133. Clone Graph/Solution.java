/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Integer, Node> nodes = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        nodes.put(node.val, new Node(node.val));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            HashSet<Integer> neighbor_ids = new HashSet<>();
            for (Node neighbor : curr.neighbors) {
                neighbor_ids.add(neighbor.val);
                if (!nodes.containsKey(neighbor.val)) {
                    nodes.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);
                }
            }
            graph.put(curr.val, neighbor_ids);
        }

        for (Node curr : nodes.values()) {
            for (int neighbor_id : graph.get(curr.val)) {
                curr.neighbors.add(nodes.get(neighbor_id));
            }
        }

        return nodes.get(node.val);
    }
}