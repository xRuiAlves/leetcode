public class Day3 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] char_counts = new int[26];

        for (int i = 0; i < magazine.length(); ++i) {
            ++char_counts[magazine.charAt(i) - 'a'];
        }

        for (int i = 0; i < ransomNote.length(); ++i) {
            int val = ransomNote.charAt(i) - 'a';
            
            if (char_counts[val] <= 0) {
                return false;
            }

            --char_counts[val];
        }

        return true;
    }
}
