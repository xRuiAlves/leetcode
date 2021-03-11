public class Solution {
    private static final class RomanIntegerPair {
        public final String roman;
        public final int integer;

        public RomanIntegerPair(String roman, int integer) {
            this.roman = roman;
            this.integer = integer;
        }
    }

    private static final RomanIntegerPair[] ROMAN_INTEGER_PAIRS = new RomanIntegerPair[]{
        new RomanIntegerPair("M", 1000),
        new RomanIntegerPair("CM", 900),
        new RomanIntegerPair("D", 500),
        new RomanIntegerPair("CD", 400),
        new RomanIntegerPair("C", 100),
        new RomanIntegerPair("XC", 90),
        new RomanIntegerPair("L", 50),
        new RomanIntegerPair("XL", 40),
        new RomanIntegerPair("X", 10),
        new RomanIntegerPair("IX", 9),
        new RomanIntegerPair("V", 5),
        new RomanIntegerPair("IV", 4),
        new RomanIntegerPair("I", 1)
    };

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < ROMAN_INTEGER_PAIRS.length; ++i) {
            RomanIntegerPair pair = ROMAN_INTEGER_PAIRS[i];
            if (num >= pair.integer) {
                sb.append(pair.roman);
                num -= pair.integer;
                --i;
            }
        }
        
        return sb.toString();
    }
}
