class Solution {
    private static final int alphabet_base = Character.getNumericValue('a');

    public static String getStringKey(String str) {
        int[] counts = new int[26];

        for (char c : str.toCharArray()) {
            ++counts[Character.getNumericValue(c) - alphabet_base];
        }

        StringBuilder sb = new StringBuilder();
        for (int count : counts) {
            sb.append('>').append(count);
        }

        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getStringKey(str);
            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(str);
        }

        for (List<String> list : map.values()) {
            res.add(list);
        }
        
        return res;
    }
}