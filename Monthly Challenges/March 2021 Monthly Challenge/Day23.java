import java.util.Arrays;

public class Day23 {
    private static final long MODULO = (long) (1e9 + 7);

    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        long count = 0;

        for (int i = 0; i < arr.length - 2; ++i) {
            int remaining = target - arr[i];
            int l = i + 1;
            int r = arr.length - 1;

            while (l < r) {
                int sum = arr[l] + arr[r];

                if (sum < remaining) {
                    ++l;
                }
                else if (sum > remaining) {
                    --r;
                } else if (arr[l] != arr[r]) {
                    int left_count = 1;
                    while (l + 1 < r && arr[l] == arr[l + 1]) {
                        ++l;
                        ++left_count;
                    }

                    int right_count = 1;
                    while (r - 1 > l && arr[r] == arr[r - 1]) {
                        --r;
                        ++right_count;
                    }

                    count += left_count * right_count;
                    ++l;
                    --r;
                } else {
                    int range = r - l;
                    count += (range + 1) * (range) / 2;
                    break;
                }
            }
        }

        return (int) (count % MODULO);
    }
}
