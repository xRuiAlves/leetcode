import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean reorderedPowerOf2(int N) {
        String nString = String.valueOf(N);
        Set<String> powersOf2 = new HashSet<>();

        for (int i = 0; i < 32; ++i) {
            int powerOf2 = 1 << i;
            char[] digits = String.valueOf(powerOf2).toCharArray();
            
            if (digits.length > nString.length()) {
                break;
            }
            
            Arrays.sort(digits);
            powersOf2.add(new String(digits));
        }
        
        char[] nStringDigits = nString.toCharArray();
        Arrays.sort(nStringDigits);
        return powersOf2.contains(new String(nStringDigits));
    }
}
