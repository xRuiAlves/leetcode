public class Day8 {
    private boolean isPallindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
    
    public int removePalindromeSub(String s) {
        if (s.isBlank()) {
            return 0;
        }
        return isPallindrome(s) ? 1 : 2;
    }
}
