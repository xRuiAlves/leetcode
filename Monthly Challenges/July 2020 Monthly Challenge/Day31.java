public class Day31 {
    public int climbStairs(int n) {
        int f0 = 1;
        int f1 = 1;

        for (int i = 2; i <= n; ++i) {
            int new_f = f0 + f1;
            f0 = f1;
            f1 = new_f;
        }
        
        return f1;
    }
}
