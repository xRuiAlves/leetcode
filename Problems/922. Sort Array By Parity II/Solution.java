class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];
        int p_even = 0;
        int p_odd = 1;

        for (int num : A) {
            if (num % 2 == 0) {
                res[p_even] = num;
                p_even += 2;
            } else {
                res[p_odd] = num;
                p_odd += 2;
            }
        }

        return res;
    }
}
