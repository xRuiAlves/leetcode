public class Day3 {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> visited = new HashMap<>();
        int count = 0;
        
        for (int num : nums) {
            visited.put(num, visited.getOrDefault(num, 0) + 1);
        }
        
        if (k == 0) {
            for (int num : visited.keySet()) {
                count += visited.get(num) >= 2 ? 1 : 0;
            }
        } else {
            for (int num : visited.keySet()) {
                count += visited.containsKey(num - k) ? 1 : 0;
            }
        }
        
        return count;
    }
}
