class Solution {
    private boolean isValidSquare(char[][] board, int y, int x) {
        boolean[] visited = new boolean[9];
        Arrays.fill(visited, false);
        
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                if (board[i][j] != '.') {
                    int idx = Character.getNumericValue(board[i][j]) - 1;
                    if (visited[idx]) {
                        return false;
                    }
                    visited[idx] = true;
                }
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        
        for (int i = 0; i < 9; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int idx = Character.getNumericValue(board[i][j]) - 1;
                    if (visited[idx]) {
                        return false;
                    }
                    visited[idx] = true;
                }
            }
            
            Arrays.fill(visited, false);
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') {
                    int idx = Character.getNumericValue(board[j][i]) - 1;
                    if (visited[idx]) {
                        return false;
                    }
                    visited[idx] = true;
                }
            }
        }
        
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSquare(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
