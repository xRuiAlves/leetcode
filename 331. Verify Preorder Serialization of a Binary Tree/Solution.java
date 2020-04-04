class Solution {
    private int node_idx = 0;

    public boolean isValidSerialization(String preorder) {
        if (preorder.isEmpty()) {
            return false;
        }
        String[] nodes = preorder.split(",");

        try {
            visit(nodes);
        } catch (Exception e) {
            return false;
        }

        return node_idx == nodes.length;
    }

    private void visit(String[] nodes) throws Exception {
        if (node_idx >= nodes.length) {
            throw new Exception("invalid");
        }

        if (nodes[node_idx].equals("#")) {
            ++node_idx;
            return;
        } else {
            ++node_idx;
            visit(nodes);
            visit(nodes);
        }
    }
}