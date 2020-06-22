public class Day22 {
    public int singleNumber(int[] nums) {
        int res = 0;
        
        for (int i = 0; i < 32; ++i) {
            int count = 0;
            int bit_selector = 1 << i;
            
            for (int num : nums) {
                if ((num & bit_selector) != 0) {
                    ++count;
                }
            }
            
            if (count % 3 != 0) {
                res |= bit_selector;
            }
        }
        
        return res;
    }
}
