class Solution {
    private void permute(List<List<Integer>> res, LinkedList<Integer> curr, boolean[] used, int[] nums) {
        if (curr.size() == nums.length) {
            res.add((List<Integer>)curr.clone());
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            curr.push(nums[i]);
            permute(res, curr, used, nums);
            curr.pop();
            used[i] = false;
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        permute(res, curr, used, nums);
        return res;
    }
}
