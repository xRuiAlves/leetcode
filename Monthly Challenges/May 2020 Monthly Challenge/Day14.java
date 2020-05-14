public class Day14 {
    private static final class Node {
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

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(null);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int numeric_val = c - 'a';
            if (curr.children[numeric_val] == null) {
                curr.children[numeric_val] = new Node(c);
            }
            curr = curr.children[numeric_val];
        }
        curr.is_word_end = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node end = getEndOfString(word);
        return end != null && end.is_word_end;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node end = getEndOfString(prefix);
        return end != null;
    }

    private Node getEndOfString(String word) {
        Node curr = root;
        for (char c : word.toCharArray()) {
            int numeric_val = c - 'a';
            if (curr.children[numeric_val] == null) {
                return null;
            }
            curr = curr.children[numeric_val];
        }
        return curr;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
