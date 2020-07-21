import java.util.*;

public class Day21 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (visit(board, word, i, j, 0, new HashSet<>())) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean visit(char[][] board, String word, int i, int j, int depth, HashSet<Integer> visited) {
        int id = i*board[0].length + j;
        if (visited.contains(id)) {
            return false;
        }

        if (board[i][j] != word.charAt(depth)) {
            visited.remove(id);
            return false;
        } else if (depth == word.length() - 1) {
            return true;
        }

        visited.add(id);
        if (i > 0 && visit(board, word, i - 1, j, depth + 1, visited)) {
            return true;
        }
        if (j > 0 && visit(board, word, i, j - 1, depth + 1, visited)) {
            return true;
        }
        if (i < board.length - 1 && visit(board, word, i + 1, j, depth + 1, visited)) {
            return true;
        }
        if (j < board[i].length - 1 && visit(board, word, i, j + 1, depth + 1, visited)) {
            return true;
        }

        visited.remove(id);
        return false;
    }
}
