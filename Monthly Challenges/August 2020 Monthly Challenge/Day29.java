import java.util.LinkedList;
import java.util.List;

public class Day29 {
    private List<Integer> flips = new LinkedList<>();

    public List<Integer> pancakeSort(int[] A) {
        if (A.length == 0) {
            return flips;
        }

        for (int i = A.length - 1; i >= 1; --i) {
            int max_idx = findMaxValIdx(A, i);

            if (max_idx != i) {
                flip(A, max_idx);
                flip(A, i);
            }
        }

        return flips;
    }

    private int findMaxValIdx(int[] arr, int upper_bound) {
        int largest = 0;

        for (int i = 1; i <= upper_bound; ++i) {
            if (arr[i] > arr[largest]) {
                largest = i;
            }
        }

        return largest;
    }

    private void flip(int[] arr, int k) {
        for (int l = 0, r = k; l < r; ++l, --r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }
        flips.add(k + 1);
    }
}
