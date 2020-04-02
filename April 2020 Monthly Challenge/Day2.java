public class Day2 {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while(n != 1) {
            if (visited.contains(n)) {
                return false;
            }
            visited.add(n);
            n = transform(n);
        }
        return true;
    }
    
    private int transform(int n) {
        int res = 0;
        while (n > 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        }
        return res;
    }
}
