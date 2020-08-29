import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private static final class LoopException extends Exception { }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = buildGraph(numCourses, prerequisites);

        boolean[] visited = new boolean[numCourses];
        boolean[] in_depth = new boolean[numCourses];

        ArrayList<Integer> courses = new ArrayList<>();

        try {
            for (int i = 0; i < numCourses; ++i) {
                if (!visited[i]) {
                    ArrayList<Integer> sub_course_path = new ArrayList<>();
                    buildCoursePath(graph, i, visited, in_depth, sub_course_path);
                    courses.addAll(sub_course_path);
                }
            }
        } catch (LoopException e) {
            return new int[]{};
        }

        Collections.reverse(courses);
        return courses.stream().mapToInt(i -> i).toArray();
    }

    private void buildCoursePath(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, boolean[] in_depth, ArrayList<Integer> sub_course_path) throws LoopException {
        if (in_depth[node]) {
            throw new LoopException();
        }
        if (visited[node]) {
            return;
        }

        in_depth[node] = true;
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            buildCoursePath(graph, neighbor, visited, in_depth, sub_course_path);
        }

        sub_course_path.add(node);

        in_depth[node] = false;
    }

    private ArrayList<ArrayList<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            graph.get(prereq[1]).add(prereq[0]);
        }

        return graph;
    }
}
