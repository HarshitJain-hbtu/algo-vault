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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // simple recursive call | time O(N) | space O(H) 
        // H = height of tree if (skew) ? n-1 : logN 
        List<Integer> ans = new ArrayList<>();
        preOrder (root , ans);
        return ans;
    }
    private void preOrder (TreeNode root , List<Integer> list){
        // simply means :  Node | left | right 
        if (root == null){
            return ;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
}