/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode node) {
        // M-2 optimal method | time O(n) | space o(1)
        if (node == null){
            return node;
        }
        ListNode head =  node ;
        while(node.next != null){
            if (node.val == node.next.val){
                node.next = node.next.next;
            }
            else{
                node = node.next;
            }
        }
        return head;
    }
    // we cannot directly print the linked list by sout 
    // when we return the head node that represent the linked list it will automatic traverse entire    
    // linked list and act like we return whole linked list 
    // we can access the whole ll if its class is defined 
}