import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new LinkedList<>();
        }

        Set<Integer> validCellIds = new HashSet<>();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (isValidCell(matrix, i, j, validCellIds)) {
                    validCellIds.add(i * matrix[i].length + j);
                }
            }
        }

        return validCellIds
            .stream()
            .map(cellId -> {
                int row = cellId / matrix[0].length;
                int col = cellId % matrix[0].length;
                return Arrays.asList(row, col);
            })
            .collect(Collectors.toList());
    }

    private boolean isValidCell(int[][] matrix, int i, int j, Set<Integer> validCellIds) {
        Set<Integer> visited = new HashSet<>();
        Stack<int[]> toVisit = new Stack<>();
        toVisit.push(new int[]{i, j});
        boolean foundPacific = false;
        boolean foundAtlantic = false;

        while (!toVisit.isEmpty() && !(foundAtlantic && foundPacific)) {
            int[] curr = toVisit.pop();
            int id = curr[0] * matrix[i].length + curr[1];

            foundPacific = foundPacific || isPacificCell(matrix, curr[0], curr[1]);
            foundAtlantic = foundAtlantic || isAtlanticCell(matrix, curr[0], curr[1]);

            if (validCellIds.contains(id)) {
                return true;
            }

            if (visited.contains(id)) {
                continue;
            }

            visited.add(id);

            List<int[]> neighbors = Arrays.asList(
                new int[]{curr[0] - 1, curr[1]},
                new int[]{curr[0] + 1, curr[1]},
                new int[]{curr[0], curr[1] - 1},
                new int[]{curr[0], curr[1] + 1}
            );

            for (int[] neighbor : neighbors) {
                if (isCellInBounds(matrix, neighbor[0], neighbor[1])
                    && matrix[neighbor[0]][neighbor[1]] <= matrix[curr[0]][curr[1]]
                ) {
                    toVisit.push(neighbor);
                }
            }
        }

        return foundAtlantic && foundPacific;
    }

    private boolean isCellInBounds(int[][] matrix, int i, int j) {
        return i >= 0 && j >= 0 && i < matrix.length && j < matrix[i].length;
    }

    private boolean isPacificCell(int[][] matrix, int i, int j) {
        return i == 0 || j == 0;
    }

    private boolean isAtlanticCell(int[][] matrix, int i, int j) {
        return i == matrix.length - 1 || j == matrix[i].length - 1;
    }
}
