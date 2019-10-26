class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> visited = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (visited.containsKey(target - nums[i])) {
                res[0] = visited.get(target-nums[i]);
                res[1] = i;
                break;
            } else {
                visited.put(nums[i], i);
            }
        }
        
        return res;
    }
}