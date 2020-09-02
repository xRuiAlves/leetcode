import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Day30 {
    private static final class Node {
        boolean is_factor;
        int val;

        Node(int val, boolean is_factor) {
            this.val = val;
            this.is_factor = is_factor;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return is_factor == node.is_factor &&
                    val == node.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(is_factor, val);
        }
    }

    HashMap<Node, HashSet<Node>> graph = new HashMap<>();
    int visited_nums = 0;

    public int largestComponentSize(int[] A) {
        Node[] nums = new Node[A.length];
        for (int i = 0; i < A.length; ++i) {
            nums[i] = new Node(A[i], false);
            graph.put(nums[i], new HashSet<>());
        }

        for (Node num_node : nums) {
            HashSet<Integer> factors = getFactors(num_node.val);
            for (int factor : factors) {
                Node factor_node = new Node(factor, true);
                addEdgeToGraph(num_node, factor_node);
                addEdgeToGraph(factor_node, num_node);
            }
        }

        int largest_component = 0;
        HashSet<Node> visited = new HashSet<>();

        for (Node num_node : nums) {
            int old_visited_nums = visited_nums;
            visit(num_node, visited);
            largest_component = Math.max(largest_component, visited_nums - old_visited_nums);
        }

        return largest_component;
    }

    private void visit(Node num_node, HashSet<Node> visited) {
        if (visited.contains(num_node)) {
            return;
        }
        visited.add(num_node);

        if (!num_node.is_factor) {
            ++visited_nums;
        }

        for (Node neighbor : graph.get(num_node)) {
            visit(neighbor, visited);
        }
    }

    private void addEdgeToGraph(Node from, Node to) {
        HashSet<Node> neighbors = graph.getOrDefault(from, null);

        if (neighbors == null) {
            neighbors = new HashSet<>();
            graph.put(from, neighbors);
        }

        neighbors.add(to);
    }

    private HashSet<Integer> getFactors(int num) {
        HashSet<Integer> factors = new HashSet<>();

        if (num % 2 == 0) {
            factors.add(2);
            while(num % 2 == 0) {
                num /= 2;
            }
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                factors.add(i);
                while(num % i == 0) {
                    num /= i;
                }
            }
        }

        if(num > 2) {
            factors.add(num);
        }

        return factors;
    }
}
