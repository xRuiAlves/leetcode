import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Day24 {
    public int[] advantageCount(int[] A, int[] B) {
        Map<Integer, Integer> num_counts = new HashMap<>();
        for (int num : A) {
            num_counts.put(num, num_counts.getOrDefault(num, 0) + 1);
        }

        TreeSet<Integer> tree = new TreeSet<>(num_counts.keySet());
        int[] res = new int[B.length];

        for (int i = 0; i < B.length; ++i) {
            Integer elem = tree.higher(B[i]);

            if (elem == null) {
                res[i] = tree.first();
                int count = num_counts.get(res[i]);
                if (count == 1) {
                    tree.pollFirst();
                }
                num_counts.put(res[i], count - 1);
            } else {
                res[i] = elem;
                int count = num_counts.get(res[i]);
                if (count == 1) {
                    tree.remove(elem);
                }
                num_counts.put(res[i], count - 1);
            }
        }

        return res;
    }
}
