import java.util.LinkedList;
import java.util.List;

public class Day12 {
    List<List<Integer>> combinations = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        visit(k, n, 1, new LinkedList<>());
        return combinations;
    }

    private void visit(int k, int n, int start, LinkedList<Integer> curr) {
        if (n < 0) {
            return;
        }
        
        if (curr.size() == k) {
            if (n == 0) {
                combinations.add(new LinkedList<>(curr));
            }
            return;
        }

        for (int i = start; i <= 9; ++i) {
            curr.addLast(i);
            visit(k, n - i, i + 1, curr);
            curr.removeLast();
        }
    }
}
