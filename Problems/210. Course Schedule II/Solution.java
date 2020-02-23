import java.util.*;

class Solution {
    private static final int[] BAD_RES = new int[]{};

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> g = new HashMap<>();
        boolean[] has_requisites = new boolean[numCourses];

        for (int i = 0; i < prerequisites.length; ++i) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            g.putIfAbsent(from, new HashSet<>());
            g.get(from).add(to);
            has_requisites[to] = true;
        }

        if (graphHasCycles(g, numCourses)) {
            return BAD_RES;
        }

        int new_root = numCourses;
        HashSet<Integer> new_root_neighbors = new HashSet<>();
        for (int i = 0; i < numCourses; ++i) {
            if (!has_requisites[i]) {
                new_root_neighbors.add(i);
            }
        }
        g.put(new_root, new_root_neighbors);

        List<Integer> top_order = findTopOrder(g, numCourses + 1, new_root);
        
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            res[i] = top_order.get(i + 1);
        }

        return res;
    }

    List<Integer> findTopOrder(HashMap<Integer, HashSet<Integer>> g, int num_verts, int start) {
        List<Integer> top_order = new LinkedList<>();
        boolean[] visited = new boolean[num_verts];

        visit(g, visited, start, top_order);

        Collections.reverse(top_order);
        return top_order;
    }

    public void visit(HashMap<Integer, HashSet<Integer>> g, boolean[] visited, int vert, List<Integer> top_order) {
        if (visited[vert]) {
            return;
        }

        visited[vert] = true;

        HashSet<Integer> neighbors = g.getOrDefault(vert, null);
        if (neighbors != null) {
            for (Integer neighbor : neighbors) {
                visit(g, visited, neighbor, top_order);
            }
        }

        top_order.add(vert);
    }

    public boolean graphHasCycles(HashMap<Integer,HashSet<Integer>> g, int num_vert) {
        boolean[] visited = new boolean[num_vert];
        boolean[] depth_stack = new boolean[num_vert];

        for (int i = 0; i < g.size(); ++i) {
            if (graphHasCycles(g, i, visited, depth_stack)) {
                return true;
            }
        }

        return false;
    }

    public boolean graphHasCycles(HashMap<Integer, HashSet<Integer>> g, int vert, boolean[] visited, boolean[] depth_stack) {
        if (!g.containsKey(vert)) {
            return false;
        }

        if (depth_stack[vert]) {
            return true;
        }

        if (visited[vert]) {
            return false;
        }

        visited[vert] = true;
        depth_stack[vert] = true;

        for (int neighbor : g.get(vert)) {
            if (graphHasCycles(g, neighbor, visited, depth_stack)) {
                return true;
            }
        }

        depth_stack[vert] = false;
        return false;
    }
}