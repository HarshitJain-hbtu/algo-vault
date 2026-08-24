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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // using BFS | time O(n) (all element) | space O(n) bcz mat ele in stack can be n/2
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){ 
            return result;
        }   

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            // for each level |  N = level size 
            int N = queue.size();
            List<Integer> level = new ArrayList<>();
            while (N-- > 0){
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}