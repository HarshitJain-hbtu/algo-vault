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
    public List<Integer> rightSideView(TreeNode root) {
        // using DFS optimal approach (trave right node first) | time O(n) | space(h) ,  h = height of tree
        List<Integer> result = new ArrayList<>();
        
        dfs(root, 0, result);
        
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result) {
        
        if (node == null) {
            return;
        }

        // First node we encounter at this level
        if (level == result.size()) {
            result.add(node.val);
        }

        // Visit right first
        dfs(node.right, level + 1, result);

        // Then visit left
        dfs(node.left, level + 1, result);
    }
}