import java.util.*;

class Solution {
    private static final class Node {
        public int depth;
        public int dist = 0;
        public int id;

        public Node(int id) {
            this(id, 0);
        }

        public Node(int id, int depth) {
            this(id, depth, 0);
        }

        public Node(int id, int depth, int dist) {
            this.id = id;
            this.depth = depth;
            this.dist = dist;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            graph.get(flight[0]).add(flight);
        }

        Queue<Node> to_visit = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);

        to_visit.offer(new Node(src));

        while (!to_visit.isEmpty()) {
            Node curr = to_visit.poll();

            if (curr.id == dst) {
                return curr.dist;
            }

            for (int[] neighbor : graph.get(curr.id)) {
                if (curr.depth <= K) {
                    to_visit.offer(new Node(neighbor[1], curr.depth + 1, curr.dist + neighbor[2]));
                }
            }
        }

        return -1;
    }
}
