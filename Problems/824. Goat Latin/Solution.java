class Solution {
    private static final String VOWELS = "aeiouAEIOU";
    private static final String WORD_SEPARATOR = " ";
    private static final String GOAT_SUFFIX = "ma";
    private static final char GOAT_POST_SUFFIX = 'a';

    public String toGoatLatin(String S) {
        if (S.isBlank()) {
            return S;
        }
        
        String[] words = S.split(WORD_SEPARATOR);
        StringBuilder sb = new StringBuilder();
        StringBuilder post_suffixes = new StringBuilder();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            if (word.isBlank()) {
                continue;
            }

            if (isConsonant(word.charAt(0))) {
                sb.append(word.substring(1)).append(word.charAt(0));
            } else {
                sb.append(word);
            }

            post_suffixes.append(GOAT_POST_SUFFIX);
            sb.append(GOAT_SUFFIX);
            sb.append(post_suffixes);
            sb.append(WORD_SEPARATOR);
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static boolean isConsonant(char c) {
        return VOWELS.indexOf(c) == -1;
    }
}
