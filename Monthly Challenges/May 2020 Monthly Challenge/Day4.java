public class Day4 {
    public int findComplement(int num) {
        int num_bits = 1 + (int)(Math.log(num)/Math.log(2));
        return ~num & ((1 << num_bits) - 1);
    }
}
