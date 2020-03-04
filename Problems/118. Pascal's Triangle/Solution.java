import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) {
            return res;
        }
        res.add(new LinkedList<>(Arrays.asList(1)));

        for (int i = 1; i < numRows; ++i) {
            List<Integer> row = new LinkedList<>();
            row.add(1);
            for (int j = 1; j < i; ++j) {
                row.add(res.get(i-1).get(j - 1) + res.get(i-1).get(j));
            }
            row.add(1);
            res.add(row);
        }

        return res;
    }
}