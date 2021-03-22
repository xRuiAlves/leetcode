import java.util.*;

public class Day22 {
    private static final String NO_MATCH_STR = "";
    private static final String VOWEL_REGEX = "[AEIOUaeiou]";
    private static final String VOWEL_REPLACEMENT_STR = "_";

    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> wordListSet = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> wordListMap = new HashMap<>();
        Map<String, String> noVowelWordListMap = new HashMap<>();

        for (String str : wordlist) {
            String lowerCaseStr = str.toLowerCase();
            wordListMap.putIfAbsent(lowerCaseStr, str);

            String noVowelsLowerCaseStr = replaceVowels(lowerCaseStr);
            noVowelWordListMap.putIfAbsent(noVowelsLowerCaseStr, str);
        }

        return Arrays
                .stream(queries)
                .map(str -> {
                    if (wordListSet.contains(str)) {
                        return str;
                    }

                    String lowerCaseStr = str.toLowerCase();
                    String match = wordListMap.getOrDefault(lowerCaseStr, null);
                    if (match != null) {
                        return match;
                    }

                    String noVowelsLowerCaseStr = replaceVowels(lowerCaseStr);
                    match = noVowelWordListMap.getOrDefault(noVowelsLowerCaseStr, null);
                    if (match != null) {
                        return match;
                    }

                    return NO_MATCH_STR;
                })
                .toArray(String[]::new);
    }

    private static final String replaceVowels(String str) {
        return str.replaceAll(VOWEL_REGEX, VOWEL_REPLACEMENT_STR);
    }
}
