public class Day14 {
    public String stringShift(String s, int[][] shift) {
        int shift_amount = 0;
        for (int i = 0; i < shift.length; ++i) {
            shift_amount += shift[i][1] * (shift[i][0] == 0 ? -1 : 1);
        }

        if (shift_amount >= 0) {
            shift_amount %= s.length();
        } else {
            shift_amount = s.length() - (-shift_amount % s.length());
        }


        if (shift_amount >= 0) {
            return s.substring(s.length() - shift_amount) + s.substring(0, s.length() - shift_amount);
        } else {
            return s.substring(shift_amount) + s.substring(0, shift_amount);
        }
    }
}
