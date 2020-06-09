import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public boolean isSubsequence(String s, String t) {
        HashMap<Character, ArrayList<Integer>> occurences = new HashMap<>();

        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            ArrayList<Integer> char_occurences = occurences.getOrDefault(c, null);

            if (char_occurences == null) {
                char_occurences = new ArrayList<>();
                occurences.put(c, char_occurences);
            }

            char_occurences.add(i);
        }

        int curr = -1;
        for (char c : s.toCharArray()) {
            ArrayList<Integer> char_occurences = occurences.getOrDefault(c, null);
            if (char_occurences == null) {
                return false;
            }

            int idx = getNext(char_occurences, curr);
            if (idx == -1) {
                return false;
            }
            curr = char_occurences.get(idx);
        }

        return true;
    }

    private int getNext(ArrayList<Integer> arr, int num) {
        int l = 0;
        int r = arr.size() - 1;

        while (l + 1 < r) {
            int m = (l + r) / 2;
            int elem = arr.get(m);

            if (elem == num) {
                if (m == arr.size() - 1) {
                    return -1;
                } else {
                    return m + 1;
                }
            }
            if (elem > num) {
                r = m;
            } else if (elem < num) {
                l = m;
            }
        }

        if (arr.get(l) > num) {
            return l;
        }
        if (arr.get(r) > num) {
            return r;
        }
        if (r == arr.size() - 1) {
            return -1;
        }
        return r + 1;
    }
}
