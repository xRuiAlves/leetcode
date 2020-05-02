public class Day16 {
    public boolean checkValidString(String s) {
        int count = 0;
        int asteriscs = 0;

        for (int i = 0; i < s.length(); ++i) {
            char symbol = s.charAt(i);

            if (symbol == '(') {
                ++count;
            } else if (symbol == ')') {
                --count;
                if (count + asteriscs < 0) {
                    return false;
                }
            } else {
                ++asteriscs;
            }
        }

        if (count == 0) {
            return true;
        }

        if (!(
            (count < 0 && count + asteriscs >= 0) ||
            (count > 0 && count - asteriscs <= 0)
        )) {
            return false;
        }

        count = 0;
        asteriscs = 0;

        for (int i = s.length() - 1; i >= 0; --i) {
            char symbol = s.charAt(i);

            if (symbol == ')') {
                ++count;
            } else if (symbol == '(') {
                --count;
                if (count + asteriscs < 0) {
                    return false;
                }
            } else {
                ++asteriscs;
            }
        }

        return (count == 0 ||
            (count < 0 && count + asteriscs >= 0) ||
            (count > 0 && count - asteriscs <= 0)
         );
    }
}
