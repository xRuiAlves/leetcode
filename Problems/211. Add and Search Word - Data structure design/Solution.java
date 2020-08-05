import java.util.Stack;

class WordDictionary {
    private static final char GENERIC_LETTER = '.';
    private static final int DICTIONARY_SIZE = 26;
    private static final char DICTIONARY_BASE = 'a';

    private static final class Node {
        Character val;
        boolean is_word_end;
        int depth;
        Node[] children = new Node[DICTIONARY_SIZE];

        Node(Character val) {
            this(val, -1, false);
        }

        Node(Character val, int depth) {
            this(val, depth, false);
        }

        Node(Character val, int depth, boolean is_word_end) {
            this.val = val;
            this.depth = depth;
            this.is_word_end = is_word_end;
        }
    }

    private Node root;

    public WordDictionary() {
        root = new Node(null);
    }

    public void addWord(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            int numeric_val = getCharValue(c);

            if (curr.children[numeric_val] == null) {
                curr.children[numeric_val] = new Node(c, i);
            }
            curr = curr.children[numeric_val];
        }

        curr.is_word_end = true;
    }

    public boolean search(String word) {
        if (word.isBlank()) {
            return true;
        }

        Stack<Node> to_visit = new Stack<>();
        to_visit.add(root);

        while (!to_visit.isEmpty()) {
            Node curr = to_visit.pop();

            if (curr.depth + 1 >=  word.length()) {
                if (curr.is_word_end) {
                    return true;
                }
                continue;
            }

            char next = word.charAt(curr.depth + 1);
            int next_numeric_value = getCharValue(next);

            if (next == GENERIC_LETTER) {
                for (Node child : curr.children) {
                    if (child != null) {
                        to_visit.add(child);
                    }
                }
            } else {
                if (curr.children[next_numeric_value] != null) {
                    to_visit.add(curr.children[next_numeric_value]);
                }
            }
        }

        return false;
    }

    private static int getCharValue(char c) {
        return c - DICTIONARY_BASE;
    }
}
