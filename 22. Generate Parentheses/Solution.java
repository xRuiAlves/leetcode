class Solution {
    private void getParenthesis(String curr, int open, int close, List<String> res) {
        if (close < open) {
            return;
        }
        
        if (open == 0 && close == 0) {
            res.add(curr);
        }
        
        if (open > 0) {
            getParenthesis(curr + "(", open - 1, close, res);
        }
        if (close > 0) {
            getParenthesis(curr + ")", open, close - 1, res);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        getParenthesis("", n, n, res);
        return res;
    }
}
