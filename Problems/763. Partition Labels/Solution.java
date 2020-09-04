import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private static final char ALPHABET_START = 'a';
    private static final char ALPHABET_END = 'z';
    private static final int ALPHABET_SIZE = ALPHABET_END - ALPHABET_START + 1;

    public List<Integer> partitionLabels(String S) {
        int[][] letter_ranges = new int[ALPHABET_SIZE][];

        for (int i = 0; i < S.length(); ++i) {
            int idx = S.charAt(i) - ALPHABET_START;

            if (letter_ranges[idx] == null) {
                letter_ranges[idx] = new int[]{i, i};
            } else {
                letter_ranges[idx][1] = i;
            }
        }

        List<int[]> ranges = Arrays.stream(letter_ranges)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(r -> r[0]))
                .collect(Collectors.toList());

        return mergeRanges(ranges).stream().map(range -> range[1] - range[0] + 1).collect(Collectors.toList());
    }

    private List<int[]> mergeRanges(List<int[]> ranges) {
        if (ranges.size() < 2) {
            return ranges;
        }

        LinkedList<int[]> merged_ranges = new LinkedList<>();
        merged_ranges.add(ranges.get(0));

        ranges.forEach(range -> {
            int[] last_range = merged_ranges.getLast();

            if (range[0] <= last_range[1]) {
                last_range[0] = Math.min(last_range[0], range[0]);
                last_range[1] = Math.max(last_range[1], range[1]);
            } else {
                merged_ranges.addLast(range);
            }
        });

        return merged_ranges;
    }
}
