public class Day23 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        int num_bits = 1 + (int) (Math.log(n - m)/Math.log(2));
        int mask = ~((1 << num_bits) - 1);
        return mask & n & m;
    }
}
