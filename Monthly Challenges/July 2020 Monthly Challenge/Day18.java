import java.util.*;

public class Day18 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new HashSet<>());
        }

        boolean[] has_dependencies = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
            has_dependencies[to] = true;
        }

        // Search for cycles
        boolean[] depth_stack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (hasCycles(graph, depth_stack, visited, i)) {
                return new int[]{};
            }
        }

        // Add aux node connecting to all nodes with no dependencies
        HashSet<Integer> neighbors = new HashSet<>();
        for (int i = 0; i < numCourses; ++i) {
            if (!has_dependencies[i]) {
                neighbors.add(i);
            }
        }
        graph.add(neighbors);

        List<Integer> top_order = getTopologicalOrder(graph);
        top_order.remove(0);
        int[] res = new int[numCourses];
        for (int i = 0; i < top_order.size(); ++i) {
            res[i] = top_order.get(i);
        }
        return res;
    }

    private List<Integer> getTopologicalOrder(ArrayList<HashSet<Integer>> graph) {
        List<Integer> top_order = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        visit(graph, top_order, visited, graph.size() - 1);
        Collections.reverse(top_order);
        return top_order;
    }

    private void visit(ArrayList<HashSet<Integer>> graph, List<Integer> top_order, boolean[] visited, int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        for (int neighbor : graph.get(node)) {
            visit(graph, top_order, visited, neighbor);
        }
        top_order.add(node);
    }

    private boolean hasCycles(ArrayList<HashSet<Integer>> graph, boolean[] depth_stack, boolean[] visited, int node) {
        if (depth_stack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }

        depth_stack[node] = true;
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (hasCycles(graph, depth_stack, visited, neighbor)) {
                return true;
            }
        }

        depth_stack[node] = false;
        return false;
    }
}
