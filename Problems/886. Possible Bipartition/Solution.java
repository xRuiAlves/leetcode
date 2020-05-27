import java.util.ArrayList;

class Solution {
    private static final char NONE = 0;
    private static final char RED = 1;
    private static final char BLACK = 2;

    private static final char getOppositeColor(char color) {
        return color == RED ? BLACK : RED;
    }

    char[] colors;
    ArrayList<Integer>[] graph;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        colors = new char[N + 1];

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for (int[] pair : dislikes) {
            graph[pair[0]].add(pair[1]);
            graph[pair[1]].add(pair[0]);
        }

        for (int i = 1; i <= N; ++i) {
            if (colors[i] == NONE && !noConflict(i, RED)) {
                return false;
            }
        }

        return true;
    }

    private boolean noConflict(int i, char color) {
        if (colors[i] != NONE) {
            return colors[i] == color;
        }
        colors[i] = color;

        for (int neighbor : graph[i]) {
            if (!noConflict(neighbor, getOppositeColor(color))) {
                return false;
            }
        }
        return true;
    }
}
