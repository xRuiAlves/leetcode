import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Day19 {
    public List<Integer> sequentialDigits(int low, int high) {
        int d1 = countDigits(low);
        int d2 = countDigits(high);
        List<Integer> numbers = new LinkedList<>();
        
        for (int i = d1; i <= d2; ++i) {
            numbers.addAll(getSequentials(i));
        }
        
        return numbers.stream().filter(d -> d >= low && d <= high).collect(Collectors.toList());
    }

    private int countDigits(int num) {
        int count = 0;

        while (num > 0) {
            num /= 10;
            ++count;
        }
        
        return count;
    }
    
    private List<Integer> getSequentials(int size) {
        List<Integer> numbers = new LinkedList<>();
        
        for (int i = 1; i <= 10 - size; ++i) {
            int number = 0;
            
            for (int j = i; j < i + size; ++j) {
                number = number*10 + j;   
            }
            
            numbers.add(number);
        }
        
        return numbers;
    }
}
