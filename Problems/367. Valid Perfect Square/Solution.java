import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    private static final Set<Integer> END_DIGITS = Stream.of(0, 1, 4, 5, 6, 9).collect(Collectors.toSet());
    private static final Set<Integer> SUMATION_DIGITS = Stream.of(1, 4, 7, 9).collect(Collectors.toSet());

    public boolean isPerfectSquare(int num) {
        if (!guardClause1(num) || !guardClause2(num)) {
            return false;
        }

        for (int i = 1; i < Integer.MAX_VALUE; ++i) {
            int square = i * i;
            if (square == num) {
                return true;
            }
            if (square > num) {
                break;
            }
        }

        return false;
    }

    private static final boolean guardClause1(int num) {
        return END_DIGITS.contains(num % 10);
    }

    private static final boolean guardClause2(int num) {
        while (!(num < 10)) {
            num = getSummation(num);
        }
        return SUMATION_DIGITS.contains(num);
    }

    private static final int getSummation(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
