import java.util.LinkedList;
import java.util.List;

class Solution {
    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    public List<String> fizzBuzz(int n) {
        List<String> fizzbuzz = new LinkedList<>();

        for (int i = 1; i <= n; ++i) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizzbuzz.add(FIZZBUZZ);
            } else if (i % 3 == 0) {
                fizzbuzz.add(FIZZ);
            } else if (i % 5 == 0) {
                fizzbuzz.add(BUZZ);
            } else {
                fizzbuzz.add(Integer.toString(i));
            }
        }
        
        return fizzbuzz;
    }
}
