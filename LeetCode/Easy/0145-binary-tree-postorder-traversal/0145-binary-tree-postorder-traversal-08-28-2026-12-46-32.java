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
    public List<Integer> postorderTraversal(TreeNode root) {
        // simple DFS (recursion) | time O(N) | space O(H) || H is height of tree log N : N-1 (skew)
        List<Integer> ans = new ArrayList<>();
        postOrder(root , ans);
        return ans;
    }
    private void postOrder(TreeNode root , List<Integer> list){
        // simply means : left child | right child | Node
        if (root == null){
            return ;
        }
        postOrder(root.left,list);
        postOrder(root.right, list);
        list.add(root.val);
    }
}