import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Day25 {
    public String largestNumber(int[] nums) {
        ArrayList<String> tokens = (ArrayList<String>) Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.toList());
        
        Collections.sort(tokens, (n1, n2) -> {
            String s1 = n1 + n2;
            String s2 = n2 + n1;
            return s2.compareTo(s1);
        });
        
        if (tokens.get(0).equals("0")) {
            return "0";
        }
        
        return String.join("", tokens);
    }
}
