class Solution {
    public void visit(String digits, HashMap<Character, List<Character>> map, List<String> res, StringBuilder sb, int idx) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char digit = digits.charAt(idx);
        for (char letter : map.get(digit)) {
            sb.append(letter);
            visit(digits, map, res, sb, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        List<String> res = new LinkedList<>();
        
        if (digits.length() > 0) {
            visit(digits, map, res, new StringBuilder(), 0);   
        }

        return res;
    }
}