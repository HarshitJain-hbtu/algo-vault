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
    public boolean isCousins(TreeNode root, int x, int y) {
        // using DFS | time O(n) | space O(h)
        // we just finding the node & check given node x&y are at same level and not sibling then cousions  
        TreeNode xx = findNode(root,x);
        TreeNode yy = findNode(root,y);

        return (level(root,xx,0) == level(root,yy,0) && ! isSibling(root,xx,yy));
    }
    private TreeNode findNode (TreeNode node, int x){
        if(node == null){
            return null;
        }
        if(node.val == x){
            return node;
        }
        TreeNode left = findNode(node.left,x);
        if(left != null){
            return left;
        }
        return findNode(node.right,x);
    }

    private int level(TreeNode node,TreeNode x  ,int lev){
        if(node == null){
            return -1;
        }
        if(node == x){
            return lev;
        }
        int left = level(node.left,x,lev + 1);
        if (left != -1){
            return left;
        }
        return level(node.right,x,lev + 1);
    }

    private boolean isSibling(TreeNode node ,TreeNode xx,TreeNode yy){
        if (node == null){
            return false;
        }
        return ((node.left == xx && node.right == yy) || (node.left == yy && node.right == xx) || isSibling(node.left ,xx ,yy) || isSibling(node.right ,xx ,yy) );
    }
}