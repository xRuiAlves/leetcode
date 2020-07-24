import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
    private static final class SearchNode {
        public int id;
        public SearchNode prev;

        public SearchNode(int val) {
            this(val, null);
        }

        public SearchNode(int id, SearchNode prev) {
            this.id = id;
            this.prev = prev;
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new LinkedList<>();
        Stack<SearchNode> to_visit = new Stack<>();
        to_visit.push(new SearchNode(0));
        int final_node_id = graph.length - 1;

        while (!to_visit.isEmpty()) {
            SearchNode node = to_visit.pop();

            if (node.id == final_node_id) {
                paths.add(buildPath(node));
                continue;
            }

            for (int neighbor : graph[node.id]) {
                to_visit.push(new SearchNode(neighbor, node));
            }
        }

        return paths;
    }

    private static List<Integer> buildPath(SearchNode node) {
        LinkedList<Integer> path = new LinkedList<>();

        while (node != null) {
            path.addFirst(node.id);
            node = node.prev;
        }

        return path;
    }
}
