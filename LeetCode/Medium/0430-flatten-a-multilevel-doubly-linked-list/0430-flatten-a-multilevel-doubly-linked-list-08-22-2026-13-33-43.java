/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {

    public Node flatten(Node head) {
        // optimal approach | time O(n) | space O(n)
        // main intution is when we find child node we save next node in stack 
        if (head == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();

        Node curr = head;

        while (curr != null) {

            // If current node has a child
            if (curr.child != null) {

                // Save original next
                if (curr.next != null) {
                    stack.push(curr.next);
                }

                // Connect current to child
                curr.next = curr.child;
                curr.child.prev = curr;

                // Remove child pointer
                curr.child = null;
            }

            // If current node is the last node
            // and there is something waiting in stack
            if (curr.next == null && !stack.isEmpty()) {

                Node nextNode = stack.pop();

                curr.next = nextNode;
                nextNode.prev = curr;
            }

            curr = curr.next;
        }

        return head;
    }
}