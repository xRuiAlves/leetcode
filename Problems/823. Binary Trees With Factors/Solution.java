import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int MODULO = (int) (1e9 + 7);

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Long> tree_counts = new HashMap<>();

        for (int num : arr) {
            tree_counts.put(num, null);
        }

        for (int i = 0; i < arr.length; ++i) {
            long count = 1;
            for (int j = i - 1; j >= 0; --j) {
                int mod = arr[i] % arr[j];
                int div = arr[i] / arr[j];
                if (mod == 0 && tree_counts.containsKey(div)) {
                    count += tree_counts.get(arr[j]) * tree_counts.get(div);
                }
            }
            tree_counts.put(arr[i], count);
        }

        return (int) (tree_counts.values().stream().mapToLong(i -> i).sum() % MODULO);
    }
}
