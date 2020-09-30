public class Day30 {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> visited = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        
        int min_num = 1;
        while (visited.contains(min_num)) {
            ++min_num;
        }
        
        return min_num;
    }
}
