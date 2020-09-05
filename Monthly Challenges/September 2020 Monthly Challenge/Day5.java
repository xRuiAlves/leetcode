/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Day5 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> l1 = inorder(root1);
        LinkedList<Integer> l2 = inorder(root2);
        List<Integer> elements = new LinkedList<>();
        
        while (!l1.isEmpty() || !l2.isEmpty()) {
            boolean from_first = true;
            
            if (l1.isEmpty()) {
                from_first = false;
            } else if (!l2.isEmpty()) {
                from_first = l1.peekFirst() < l2.peekFirst();
            }

            elements.add(from_first ? l1.pollFirst() : l2.pollFirst());
        }
        
        return elements;
    }
    
    private LinkedList<Integer> inorder(TreeNode root) {
        LinkedList<Integer> order = new LinkedList<>();
        Stack<TreeNode> to_visit = new Stack<>();
        TreeNode curr = root;
        
        while (!to_visit.isEmpty() || curr != null) {
            while (curr != null) {
                to_visit.add(curr);
                curr = curr.left;
            }
            
            curr = to_visit.pop();
            order.add(curr.val);
            curr = curr.right;
        }
        
        return order;
    }
}
