import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }

        List<Integer> res = new LinkedList<>();
        HashMap<Integer, HashSet<Integer>> g = new HashMap<>();
        HashMap<Integer, Integer> node_degrees = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            g.put(i, new HashSet<>());
        }

        for (int i = 0; i < edges.length; ++i) {
            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> to_visit = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            int num_neighbors = g.get(i).size();
            node_degrees.put(i, num_neighbors);
            if (num_neighbors == 1) {
                to_visit.add(i);
            }
        }

        while(!to_visit.isEmpty()) {
            int queue_size = to_visit.size();

            for (int i = 0; i < queue_size; ++i) {
                int node = to_visit.poll();

                if (n <= 2) {
                    res.add(node);
                }

                for (int neighbor : g.get(node)) {
                    node_degrees.put(neighbor, node_degrees.get(neighbor) - 1);
                    if (node_degrees.get(neighbor) == 1) {
                        to_visit.add(neighbor);
                    }
                }
            }

            n -= queue_size;
        }

        return res;
    }
}