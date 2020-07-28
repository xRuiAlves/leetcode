import java.util.Arrays;

public class Day28 {
    private static final int NUM_TASKS = 26;
    private static final char FIRST_TASK = 'A';

    public int leastInterval(char[] tasks, int n) {
        int[] task_counts = new int[NUM_TASKS];

        for (char task : tasks) {
            ++task_counts[task - FIRST_TASK];
        }
        Arrays.sort(task_counts);
        int most_frequent = task_counts[NUM_TASKS - 1] - 1;
        int num_spaces = most_frequent * n;

        for (int i = NUM_TASKS - 2; i >= 0; --i) {
            num_spaces -= Math.min(most_frequent, task_counts[i]);
        }

        return tasks.length + Math.max(num_spaces, 0);
    }
}
