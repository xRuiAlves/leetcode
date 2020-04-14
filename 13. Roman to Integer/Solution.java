import java.util.*;

class Solution {
    private static final Map<Character, Integer> SYMBOL_VALUES = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    private static final Map<Character, Set<Character>> SYMBOL_MODIFIERS = new HashMap<>() {{
        put('I', new HashSet<>(Arrays.asList('V', 'X')));
        put('X', new HashSet<>(Arrays.asList('L', 'C')));
        put('C', new HashSet<>(Arrays.asList('D', 'M')));
    }};

    private static final HashSet<Character> IMEDIATE_VALUES = new HashSet<>(Arrays.asList('V', 'L', 'D', 'M'));

    public int romanToInt(String s) {
        int int_val = 0;

        for (int i = 0; i < s.length(); ++i) {
            char symbol = s.charAt(i);

            if (IMEDIATE_VALUES.contains(symbol)) {
                int_val += SYMBOL_VALUES.get(symbol);
            } else {
                if (i + 1 < s.length() && SYMBOL_MODIFIERS.get(symbol).contains(s.charAt(i + 1))) {
                    int_val -= SYMBOL_VALUES.get(symbol);
                } else {
                    int_val += SYMBOL_VALUES.get(symbol);
                }
            }
        }

        return int_val;
    }
}
