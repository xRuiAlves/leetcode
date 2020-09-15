public class Day15 {
    public int lengthOfLastWord(String s) {
        int length = 0;
        
        for (int i = s.length() - 1; i >= 0; --i) {
            if (length != 0 && s.charAt(i) == ' ') {
                break;
            }
            length += s.charAt(i) != ' ' ? 1 : 0;
        }
        
        return length;
    }
}
