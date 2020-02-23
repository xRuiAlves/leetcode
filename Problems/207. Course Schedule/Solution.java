class Solution {
    public boolean graphHasCycles(HashMap<Integer, HashSet<Integer>> m, int numCourses) {
        boolean[] visited = new boolean[numCourses];
        boolean[] depth_stack = new boolean[numCourses];

        for (int i = 0; i < m.size(); ++i) {
            if (graphHasCycles(m, visited, depth_stack, i)) {
                return true;
            }
        }

        return false;
    }

    public boolean graphHasCycles(HashMap<Integer, HashSet<Integer>> m, boolean[] visited, boolean[] depth_stack, int vertex) {
        if (!m.containsKey(vertex)) {
            return false;
        }

        if (depth_stack[vertex]) {
            return true;
        }

        if (visited[vertex]) {
            return false;
        }

        visited[vertex] = true;
        depth_stack[vertex] = true;

        for (int neighbor : m.get(vertex)) {
            if (graphHasCycles(m, visited, depth_stack, neighbor)) {
                return true;
            }
        }

        depth_stack[vertex] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> m = new HashMap<>();

        for (int i = 0; i < prerequisites.length; ++i) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];

            m.putIfAbsent(from, new HashSet<>());
            m.get(from).add(to);
        }

        return !graphHasCycles(m, numCourses);
    }
}