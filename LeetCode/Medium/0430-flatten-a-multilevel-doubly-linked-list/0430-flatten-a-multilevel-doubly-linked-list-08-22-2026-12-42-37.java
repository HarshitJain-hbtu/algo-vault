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
        // using recursion | time O(n* n) (finding tail make it worse) | space O(d) nesting depth
        if (head == null){
            return head;
        }
        Node curr = head;

        while (curr != null){
            // flatten child
            if (curr.child != null){
                Node next = curr.next;
                curr.next = flatten(curr.child);
                curr.next.prev = curr;
                curr.child = null;

                // finding tail
                while (curr.next != null){
                    curr = curr.next;
                }

                // connect tail node with next ele 
                if (next != null){
                    curr.next = next;
                    curr.next.prev = curr;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}