import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day15 {
    public String reverseWords(String s) {
        List<String> res = Arrays.asList(s.trim().split(" "));
        Collections.reverse(res);
        res = res.stream().filter(token -> !token.isBlank()).collect(Collectors.toList());
        return String.join(" ", res);
    }
}
