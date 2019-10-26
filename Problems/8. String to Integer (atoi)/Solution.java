class Solution {
    public int myAtoi(String str) {
        long res = 0;
        int mult = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                if (mult != 0) {
                    break;
                } else {
                    mult = -1;
                    continue;
                }
            } 
            if (str.charAt(i) == '+') {
                if (mult != 0) {
                    break;
                } else {
                    mult = 1;
                    continue;
                }
            } 
            int val = Character.getNumericValue(str.charAt(i));
            if (val >= 0 && val <= 9) {
                mult = (mult == 0) ? 1 : mult;
                res = (res*10) + val;
                if ((res*mult) < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                if ((res*mult) > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
            } else {
                if (mult != 0) {
                    break;
                }
                if (mult == 0 && str.charAt(i) != ' ') {
                    break;
                }
            }
        }
        return (int)(res*mult);
    }
}