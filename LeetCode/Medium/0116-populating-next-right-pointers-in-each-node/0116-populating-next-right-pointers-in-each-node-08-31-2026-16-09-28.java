/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
// we traversing level by level and during traversing we connect childs of level below it 
class Solution {
    public Node connect(Node root) {
        // M-2 optimal approach without using queue |time complexity is O(n) and  space O(1)
        if (root == null) {
            return null;
        }
        // for a particular level we just connect their childs
        Node leftmost = root;
        while(leftmost.left != null){
            Node current = leftmost;
            while(current != null){
                current.left.next = current.right;
                if(current.next != null){
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            // level is end 
            leftmost = leftmost.left;
        }
        return root;
    }
}