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
    public boolean isSymmetric(TreeNode root) {
        /*
        here clearly BFS apply as if each level is mirror then symm 
        but if we add normally then how can we get mid nodes from queue and 
        then how to know that we check ele are at mirror position or not like ex 2 
        so add like they are just mirror ele and check pair of two
        time and space comp same as BFS O(N) both 
        */
        Queue<TreeNode> queue = new LinkedList <>();
        queue.offer(root.left);
        queue.offer(root.right);

        while(!queue.isEmpty()){
            TreeNode Left = queue.poll();
            TreeNode Right = queue.poll();
            
            if(Left == null && Right == null){
                continue;
            }
            if(Left == null || Right == null){
                return false;
            }
            if(Left.val != Right.val){
                return false;
            }
            // add elements mirrorly
            queue.offer(Left.left);
            queue.offer(Right.right);
            queue.offer(Left.right);
            queue.offer(Right.left);

        }
        // till now no false is return means tree is symm 
        return true;
    }
}