import java.util.*;

public class Day27 {
    private static final class Edge {
        String from;
        String to;
        double val;

        Edge(String from, String to, double val){
            this.from = from;
            this.to = to;
            this.val = val;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        Map<String, List<Edge>> graph = new HashMap<>();

        if (equations.isEmpty() || queries.isEmpty()) {
            return res;
        }

        for (int i = 0; i < equations.size(); ++i) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            graph.putIfAbsent(var1, new ArrayList<>());
            graph.putIfAbsent(var2, new ArrayList<>());
            graph.get(var1).add(new Edge(var1, var2, values[i]));
            graph.get(var2).add(new Edge(var2, var1, 1 / values[i]));
        }

        for (int i = 0; i < queries.size(); ++i) {
            List<String> query = queries.get(i);
            String from  = query.get(0);
            String to = query.get(1);

            res[i] = (graph.containsKey(from) && graph.containsKey(to))
                ? dfs(graph, from, to, 1, new HashSet<>())
                : -1;
        }

        return res;
    }

    private double dfs(Map<String, List<Edge>> graph, String from, String to, double res, Set<String> visited) {
        if (from.equals(to)) {
            return res;
        }

        visited.add(from);

        for (Edge edge : graph.get(from)) {
            if (visited.contains(edge.to)) {
                continue;
            }

            double partial_res = dfs(graph, edge.to, to, res * edge.val, visited);
            if (partial_res != -1) {
                return partial_res;
            }
        }

        return -1;
    }
}
