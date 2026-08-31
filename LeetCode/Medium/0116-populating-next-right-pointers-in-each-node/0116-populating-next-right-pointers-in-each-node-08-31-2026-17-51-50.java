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
// we traversing level by level and during traversing we connect nodes of that level using previous variable 
class Solution {
    public Node connect(Node root) {
        // M-1 brut approach using queue |time complexity is O(n) and  space O(n)
        if (root == null) {
            return null;
        }

        Queue <Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            Node previous = null ;
            for (int i = 0 ; i< levelSize ; i++){
                Node current = queue.poll();

                // connect previous node to current node
                if ( previous != null){
                    previous.next = current;
                }
                previous = current;

                if (current.left != null){
                    queue.offer(current.left);
                }
                if (current.right != null){
                    queue.offer(current.right);
                }
            }
            // after each level (optional step)
            previous.next = null;
        }
        return root;
    }
}