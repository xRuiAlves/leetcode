class Solution {
    public int climbStairs(int n) {
        int n1 = 0;
        int n2 = 1;
        
        for (int i = 0; i < n; ++i) {
            int sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        
        return n2;
    }
}
