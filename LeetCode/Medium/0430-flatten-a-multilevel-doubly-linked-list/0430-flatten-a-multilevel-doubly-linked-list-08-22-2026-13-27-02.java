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
        // better app | time O(n) and space O(d) nesting depth
        if (head == null) {
            return null;
        }

        flattenList(head);

        return head;
    }

    private Node flattenList(Node curr) {

        Node node = curr;
        Node last = null;

        while (node != null) {

            Node next = node.next;

            if (node.child != null) {

                Node child = node.child;

                // Flatten child list
                Node childTail = flattenList(child);

                // Connect node to child
                node.next = child;
                child.prev = node;

                // Connect child tail to original next
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }

                // Remove child pointer
                node.child = null;

                last = childTail;
            } 
            else {
                last = node;
            }

            node = next;
        }

        return last;
    }
}