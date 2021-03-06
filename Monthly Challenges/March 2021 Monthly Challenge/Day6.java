import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Day6 {
    private class TrieNode {
        private static final char ALPHABET_START = 'a';
        private static final char ALPHABET_END = 'z';
        private static final int ALPHABET_SIZE = ALPHABET_END - ALPHABET_START + 1;
        
        public boolean isWordEnd = false;
        public Character value;
        public TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        public int depth = 0;

        TrieNode(Character value) {
            this.value = value;
        }

        TrieNode() {
            this(null);
        }

        boolean isLeaf() {
            return Arrays.stream(children).allMatch(Objects::isNull);
        }

        TrieNode addChild(char value) {
            int childIndex = value - ALPHABET_START;
            if (children[childIndex] == null) {
                children[childIndex] = new TrieNode(value);
                children[childIndex].depth = this.depth + 1;
            }

            return children[childIndex];
        }
    }

    private final TrieNode trieRoot = new TrieNode();

    private TrieNode insertInTrie(String word) {
        TrieNode curr = trieRoot;

        for (char c : word.toCharArray()) {
            curr = curr.addChild(c);
        }

        curr.isWordEnd = true;
        return curr;
    }

    public int minimumLengthEncoding(String[] words) {
        Set<TrieNode> leafCandidates = new HashSet<>();

        for (String word : words) {
            String reversedWord = (new StringBuilder(word)).reverse().toString();
            TrieNode wordEnd = insertInTrie(reversedWord);
            leafCandidates.add(wordEnd);
        }

        return leafCandidates
            .stream()
            .filter(node -> node.isWordEnd && node.isLeaf())
            .mapToInt(node -> node.depth + 1)
            .sum();
    }
}
