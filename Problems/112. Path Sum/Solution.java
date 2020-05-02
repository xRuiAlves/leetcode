class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }    
        
        int new_sum = sum - root.val;
        
        if (root.left == null && root.right == null) {
            return new_sum == 0;
        }
        
        return hasPathSum(root.left, new_sum) || hasPathSum(root.right, new_sum);
    }
}