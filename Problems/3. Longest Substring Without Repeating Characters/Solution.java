class Solution {    
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> reps = new HashMap<>();
        int index = 0;
        int max_len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (reps.containsKey(s.charAt(i))) {
                index = Math.max(index, reps.get(s.charAt(i)) + 1);
                reps.put(s.charAt(i), i);
            } else {
                reps.put(s.charAt(i), i);
            }
            max_len = Math.max(max_len, i - index + 1);
        }
        return max_len;
    }
}