import java.util.*;

class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        ArrayList<Integer> l1 = getDigits(s1);
        ArrayList<Integer> l2 = getDigits(s2);
        Collections.sort(l1);
        Collections.sort(l2);

        return isBigger(l1, l2) || isBigger(l2, l1);
    }

    private boolean isBigger(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        for (int i = 0; i < l1.size(); ++i) {
            if (l1.get(i) < l2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<Integer> getDigits(String s) {
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            digits.add(s.charAt(i) - 'a');
        }
        return digits;
    }
}
