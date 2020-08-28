/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */

class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int d0 = rand7() - 1 ;
            int d1 = rand7() - 1;
            int val = d1*7 + d0;
            
            if (val < 40) {
                return (val % 10) + 1;
            }
        }
    }
}
