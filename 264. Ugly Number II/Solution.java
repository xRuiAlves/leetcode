import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {
        int count = 0;
        TreeSet<Integer> uglies = new TreeSet<>();
        uglies.add(1);

        while(true) {
            int num = uglies.pollFirst();
            ++count;

            if (count == n) {
                return num;
            }

            if (num <= Integer.MAX_VALUE / 2) {
                uglies.add(num * 2);
            }
            if (num <= Integer.MAX_VALUE / 3) {
                uglies.add(num * 3);
            }
            if (num <= Integer.MAX_VALUE / 5) {
                uglies.add(num * 5);
            }
        }
    }
}