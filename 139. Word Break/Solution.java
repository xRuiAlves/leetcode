import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited.add(0);

        while(!queue.isEmpty()) {
            int idx = queue.poll();

            if (idx == s.length()) {
                return true;
            }

            List<Integer> next_indexes = visit(s, idx, wordDict);
            for (int next_index : next_indexes) {
                if (!visited.contains(next_index)) {
                    visited.add(next_index);
                    queue.offer(next_index);
                    if (next_index == s.length()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private List<Integer> visit(String s, int idx, List<String> wordDict) {
        List<Integer> indexes = new LinkedList<>();

        for (String word : wordDict) {
            int size = verify(s, idx, word);
            if (size != -1) {
                indexes.add(idx + size);
            }
        }

        return indexes;
    }

    private int verify(String s, int idx, String candidate) {
        int size = 0;

        if (idx + candidate.length() > s.length()) {
            return -1;
        }

        for (int i = 0; i < candidate.length(); ++i) {
            if (s.charAt(idx + i) != candidate.charAt(i)) {
                return -1;
            }
            ++size;
        }

        return size;
    }
}