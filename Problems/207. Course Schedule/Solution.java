import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<HashSet<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new HashSet<>());
        }

        for (int i = 0; i < prerequisites.length; ++i) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            graph.get(from).add(to);
        }

        boolean[] depth_stack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; ++i) {
            if (hasCycles(graph, depth_stack, visited, i)) {
                return false;
            }
        }
        return true;
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