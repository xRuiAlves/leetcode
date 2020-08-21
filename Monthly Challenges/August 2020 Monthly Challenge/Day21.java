class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int p_even = 0;
        int p_odd = res.length - 1;

        for (int num : A) {
            if (num % 2 == 0) {
                res[p_even++] = num;
            } else {
                res[p_odd--] = num;
            }
        }

        return res;
    }
}
