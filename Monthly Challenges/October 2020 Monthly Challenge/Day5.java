public class Day5 {
    public int bitwiseComplement(int N) {
        int num_bits = 1 + (int)(Math.log(N)/Math.log(2));
        return ~N & ((1 << num_bits) - 1);
    }
}
