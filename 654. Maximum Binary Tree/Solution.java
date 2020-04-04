/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums, int n0, int n1) {
        int size = n1 - n0;
        
        if (size <= 0) {
            return null;
        }
        
        if (size == 1) {
            return new TreeNode(nums[n0]);
        }
        
        int max_idx = n0;
        for (int i = n0 + 1; i < n1; ++i) {
            if (nums[i] > nums[max_idx]) {
                max_idx = i;
            }
        }
        
        TreeNode node = new TreeNode(nums[max_idx]);
        node.right = constructMaximumBinaryTree(nums, max_idx + 1, n1);
        node.left = constructMaximumBinaryTree(nums, n0, max_idx);
        
        return node;
    }
}