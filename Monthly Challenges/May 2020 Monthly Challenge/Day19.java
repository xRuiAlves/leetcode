import java.util.*;

public class Day19 {
    private Stack<Integer> nums, totals;

    public StockSpanner() {
        nums = new Stack<>();
        totals = new Stack<>();
    }

    public int next(int price) {
        int total = 1;
        
        while(!nums.isEmpty() && nums.peek() <= price) {
            nums.pop();
            total += totals.pop();
        }
        
        totals.push(total);
        nums.push(price);
        return total;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
