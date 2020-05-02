import java.util.*;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int count = 0;
        TreeSet<Integer> uglies = new TreeSet<>();
        uglies.add(1);

        while (true) {
            int num = uglies.pollFirst();
            if (++count == n) {
                return num;
            }

            for (int prime : primes) {
                if (num <= Integer.MAX_VALUE / prime) {
                    uglies.add(num * prime);
                }
            }
        }
    }
}