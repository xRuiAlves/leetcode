public class Day3 {
    private static final int LOOP_SIZE = 14;

    public int[] prisonAfterNDays(int[] cells, int N) {
        int num_iters = N % LOOP_SIZE != 0 ? N % LOOP_SIZE : LOOP_SIZE;

        for (int i = 0; i < num_iters; ++i) {
            int last = cells[0];
            cells[0] = 0;

            for (int j = 1; j < 7; ++j) {
                int curr = cells[j];
                cells[j] = (last == cells[j + 1]) ? 1 : 0;
                last = curr;
            }

            cells[7] = 0;
        }
        
        return cells;
    }
}
