import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int ALPHABET_SIZE = 26;
    private static final char ALPHABET_BASE = 'a';
    private static final char VISITED = '#';
    
    class Node {
        
        Node[] neighbors = new Node[ALPHABET_SIZE];
        String value;
    }

    public Node prepareTrie(String[] data) {
        Node root = new Node();
        
        for (String elem : data) {
            Node curr = root;
            for (char c : elem.toCharArray()) {
                int i = c - ALPHABET_BASE;
                
                if (curr.neighbors[i] == null) {
                    curr.neighbors[i] = new Node();
                }
                
                curr = curr.neighbors[i];
            }
            
            curr.value = elem;
        }

        return root;
    }


    public List<String> findWords(char[][] board, String[] words) {
        Node root = prepareTrie(words);
        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                search(board, i, j, root, res);
            }
        }

        return res;
    }

    public void search(char[][] board, int i, int j, Node node, List<String> res) {
        char c = board[i][j];
        if (c == VISITED || node.neighbors[c - ALPHABET_BASE] == null) {
            return;
        }
        
        node = node.neighbors[c - ALPHABET_BASE];
        
        if (node.value != null) {
            res.add(node.value);
            node.value = null;
        }

        board[i][j] = VISITED;
        
        if (i > 0) {
            search(board, i - 1, j, node, res);
        }
        if (j > 0) {
            search(board, i, j - 1, node, res);
        }
        if (i < board.length - 1) {
            search(board, i + 1, j, node, res);
        }
        if (j < board[i].length - 1) {
            search(board, i, j + 1, node, res);
        }
        
        board[i][j] = c;
    }
}
