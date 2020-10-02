import java.util.LinkedList;
import java.util.List;

public class Day2 {
    List<List<Integer>> combinations = new LinkedList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        visit(candidates, target, 0, new LinkedList<>());
        return combinations;
    }
    
    private void visit(int[] candidates, int sum, int idx, LinkedList<Integer> curr) {
        if (sum == 0) {
            combinations.add(new LinkedList<>(curr));
            return;
        }
        if (sum < 0) {
            return;
        }
        
        for (int i = idx; i < candidates.length; ++i) {
            curr.addLast(candidates[i]);
            visit(candidates, sum - candidates[i], i, curr);
            curr.removeLast();
        }
    }
}
