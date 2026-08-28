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
    public List<Integer> inorderTraversal(TreeNode root) {
        // simple DFS | time O(N) | space O(H)   \\ H = (skew) ? N-1 : log N  
        List<Integer> ans = new ArrayList<>();
        inOrder(root, ans);
        return ans;
    }
    private void inOrder (TreeNode root , List<Integer> list){
        // simply means : left | Node | right 
        if (root == null){
            return ;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}