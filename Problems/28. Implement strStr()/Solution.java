class Solution {
    public int strStr(String haystack, String needle) {
        int needle_pointer = 0;
        int haystack_pointer = 0;

        for (; haystack_pointer < haystack.length() && needle_pointer < needle.length(); ++haystack_pointer) {
            if (haystack.charAt(haystack_pointer) == needle.charAt(needle_pointer)) {
                ++needle_pointer;
            } else {
                haystack_pointer -= needle_pointer;
                needle_pointer = 0;
            }
        }

        return needle_pointer == needle.length() ? haystack_pointer - needle.length() : -1;
    }
}
