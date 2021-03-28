import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    private static final char ALPHABET_START = 'a';
    private static final char ALPHABET_END = 'z';
    private static final int ALPHABET_SIZE = ALPHABET_END - ALPHABET_START + 1;

    private static final List<String> NUMBERS = Arrays.asList(
        "zero",
        "two",
        "eight",
        "four",
        "six",
        "five",
        "one",
        "three",
        "seven",
        "nine"
    );

    private static final Map<String, Character> NUMBERS_STR_TO_DIGIT = new HashMap<>() {{
        put("zero",  '0');
        put("one",   '1');
        put("two",   '2');
        put("three", '3');
        put("four",  '4');
        put("five",  '5');
        put("six",   '6');
        put("seven", '7');
        put("eight", '8');
        put("nine",  '9');
    }};

    private static final Map<String, Map<Character, Integer>> NUMBERS_CHARS_COUNT = NUMBERS
        .stream()
        .collect(Collectors.toMap(
            str -> str,
            str -> {
                Map<Character, Integer> counts = new HashMap<>();
                for (char c : str.toCharArray()) {
                    counts.put(c, counts.getOrDefault(c, 0) + 1);
                }
                return counts;
            }
        ));

    public String originalDigits(String s) {
        int[] inputCharCounts = countChars(s);
        StringBuilder sb = new StringBuilder();

        for (String numberString : NUMBERS) {
            Map<Character, Integer> numberCharCounts = NUMBERS_CHARS_COUNT.get(numberString);

            int numberStringCount = Integer.MAX_VALUE;
            for (Map.Entry<Character, Integer> entry : numberCharCounts.entrySet()) {
                int inputCount = inputCharCounts[entry.getKey() - ALPHABET_START];
                numberStringCount = Math.min(numberStringCount, inputCount / entry.getValue());
            }

            for (Map.Entry<Character, Integer> entry : numberCharCounts.entrySet()) {
                inputCharCounts[entry.getKey() - ALPHABET_START] -= numberStringCount * entry.getValue();
            }

            char digit = NUMBERS_STR_TO_DIGIT.get(numberString);
            for (int i = 0; i < numberStringCount; ++i) {
                sb.append(digit);
            }
        }

        String res = sb.toString();
        char[] res_chars = res.toCharArray();
        Arrays.sort(res_chars);
        return new String(res_chars);
    }

    private int[] countChars(String s) {
        int[] charCounts = new int[ALPHABET_SIZE];

        for (char c : s.toCharArray()) {
            ++charCounts[c - ALPHABET_START];
        }

        return charCounts;
    }
}
