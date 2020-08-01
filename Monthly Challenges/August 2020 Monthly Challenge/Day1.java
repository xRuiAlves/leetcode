public class Day1 {
    public boolean detectCapitalUse(String word) {
        int count = word.chars().reduce(0, (acc, curr) -> acc + charIsUpperCase(curr));
        return count == 0
            || count == word.length()
            || (count == 1 && charIsUpperCase(word.charAt(0)) == 1);
    }

    private int charIsUpperCase(int c) {
        return c >= 'A' && c <= 'Z' ? 1 : 0;
    }
}
