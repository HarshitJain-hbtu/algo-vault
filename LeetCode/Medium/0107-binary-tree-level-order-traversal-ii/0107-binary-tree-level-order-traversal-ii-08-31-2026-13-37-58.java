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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // M-2 using BFS (almost same) | time O(n * n) | space O(n)    
        // inserting at index 0 requires shifting existing elements, so technically this costs O(number of levels) per level means worst-case time complexity of this implementation is O(n²).if skew tree so n level 
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }
        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0;i< levelSize ;i++){
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left != null ){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null ){
                    queue.offer(currentNode.right);
                }
            }
            // using add method at particular index
            result.add(0,currentLevel);
        }
        return result ;
    }
}