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
    public TreeNode invertTree(TreeNode root) {
        // preorder traversal 
        // time comp O(n) and space O(log n)due to recursion h = log n 
        if (root == null) {
            return null;
        }

        // Swap first (Preorder)
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Then recursively process children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}