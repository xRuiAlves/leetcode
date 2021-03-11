public class Solution {
    private static final String NUMBER_PATTERN = "^([+-]?\\d+\\.\\d+|[+-]?\\d+|[+-]?\\.\\d+|[+-]?\\d+\\.)([eE][+-]?\\d+)?$";
    
    public boolean isNumber(String s) {
        return s.matches(NUMBER_PATTERN);
    }
}
