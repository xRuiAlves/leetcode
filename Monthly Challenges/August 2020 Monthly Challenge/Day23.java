import java.util.LinkedList;
import java.util.List;

class StreamChecker {
    private static final class Trie {
        private final class Node {
            Character val;
            boolean is_word_end;
            Node[] children = new Node[26];

            Node(Character val, boolean is_word_end) {
                this.val = val;
                this.is_word_end = is_word_end;
            }

            Node(Character val) {
                this(val, false);
            }
        }

        private Node root;
        private List<Node> visiting;

        public Trie() {
            root = new Node(null);
            visiting = new LinkedList<>();
        }

        public void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                int numeric_val = getCharIndex(c);
                if (curr.children[numeric_val] == null) {
                    curr.children[numeric_val] = new Node(c);
                }
                curr = curr.children[numeric_val];
            }
            curr.is_word_end = true;
        }
        
        public boolean advance(char c) {
            visiting.add(root);
            boolean found_word = false;
            List<Node> new_visiting = new LinkedList<>();
            
            for (Node node : visiting) {
                Node next = node.children[getCharIndex(c)];
                if (next != null) {
                    new_visiting.add(next);
                    found_word = found_word || next.is_word_end;
                }
            }
            
            visiting = new_visiting;
            return found_word;
        }
        
        private int getCharIndex(char c) {
            return c - 'a';
        }
    }
    
    private final Trie trie;
    
    public StreamChecker(String[] words) {
        this.trie = new Trie();
        
        for (String word : words) {
            this.trie.insert(word);
        }
    }

    public boolean query(char letter) {
        return this.trie.advance(letter);
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
