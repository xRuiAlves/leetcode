import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        visit(s, res, new LinkedList<>(), 0);
        return res;
    }

    private void visit(String s, List<List<String>> res, LinkedList<String> curr, int idx) {
        if (idx == s.length()) {
            res.add(new LinkedList<>(curr));
            return;
        }

        for (int i = idx + 1; i <= s.length(); ++i) {
            if (isPallindrome(s.toCharArray(), idx, i - 1)) {
                curr.addLast(s.substring(idx, i));
                visit(s, res, curr, i);
                curr.removeLast();
            }
        }
    }

    private boolean isPallindrome(char[] chars, int l, int r) {
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }
}