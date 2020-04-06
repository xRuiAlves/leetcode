import java.util.*;

public class Day6 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String hash = getHash(str);
            List<String> list = map.getOrDefault(hash, new LinkedList<>());
            list.add(str);
            map.put(hash, list);
        }

        List<List<String>> res = new LinkedList<>();
        for (List<String> list : map.values()) {
            res.add(list);
        }

        return res;
    }

    private String getHash(String str) {
        int[] char_counts = new int[26];
        for (int i = 0; i < str.length(); ++i) {
            ++char_counts[str.charAt(i) - 'a'];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {
            sb.append('>').append(char_counts[i]);
        }

        return sb.toString();
    }
}
