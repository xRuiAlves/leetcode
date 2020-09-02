import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int largestComponentSize(int[] A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < A.length; ++i) {
            HashSet<Integer> factors = factorize(A[i]);

            for (int factor : factors) {
                ArrayList<Integer> factor_numbers = map.getOrDefault(factor, new ArrayList<>());
                factor_numbers.add(A[i]);
                map.put(factor, factor_numbers);
            }
        }

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int num : A) {
            graph.put(num, new HashSet<>());
        }

        for (ArrayList<Integer> connected_numbers : map.values()) {
            for (int i = 0; i < connected_numbers.size(); ++i) {
                HashSet<Integer> row = graph.get(connected_numbers.get(i));
                for (int j = 0; j < connected_numbers.size(); ++j) {
                    if (i != j) {
                        row.add(connected_numbers.get(j));
                        graph.get(connected_numbers.get(j)).add(connected_numbers.get(i));
                    }
                }
            }
        }

        HashSet<Integer> visited = new HashSet<>();
        int largest_component = 0;

        for (int num : A) {
            int before_visiting_size = visited.size();
            visit(graph, num, visited);
            int component_size = visited.size() - before_visiting_size;
            largest_component = Math.max(largest_component, component_size);
        }

        return largest_component;
    }

    private void visit(HashMap<Integer, HashSet<Integer>> graph, int num, HashSet<Integer> visited) {
        if (visited.contains(num)) {
            return;
        }
        visited.add(num);

        for (int neighbor : graph.get(num)) {
            visit(graph, neighbor, visited);
        }
    }

    private HashSet<Integer> factorize(int num) {
        HashSet<Integer> factors = new HashSet<>();
        factors.add(num);

        for (int i = 2; i <= num/2; ++i) {
            if (num % i == 0) {
                factors.add(i);
                factors.add(num/i);
            }
        }

        return factors;
    }
}
