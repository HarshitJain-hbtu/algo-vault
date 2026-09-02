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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // using dfs bcz we go up and down | we find diameter of every node by height (postorder)
        // time O(n) and space O(h)
        height(root);
        return diameter;
    }
    private int height(TreeNode node){
        if (node == null){
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        // calculate & update the diameter 
        int dia = leftHeight + rightHeight + 2;
        diameter = Math.max(diameter,dia);
        
        return Math.max(leftHeight , rightHeight) + 1;
    }
}