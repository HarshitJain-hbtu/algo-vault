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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // intuation - we know reverse but after it we need two things last and newEnd 
        // time O(n) & space O(1)
        // edge case
        if (left == right){
            return head ;
        }
        
        // skip the left-1 element
        ListNode current = head ;
        ListNode prev = null ; 
        for (int i = 0; current != null && i < left -1;i++){
            prev = current ;
            current = current.next;
        }
        // After this loop current → left-th node and prev → (left-1)-th node
        ListNode last = prev;
        ListNode  newEnd = current;
        // last → node before reversal starts and newEnd → will become the end of reversed portion

        // reverse the nodes from left to right
        ListNode next = current.next;
        for (int i = 0;current != null && i < right -left + 1; i++){
            current.next = prev;
            prev = current;
            current = next;
            if (next != null){
                next =  next.next;
            }
        }
        // now prev → head of reversed section and current → first node after right
        // Connect left part with reversed part
        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }
        // Connect reversed part with right part
        newEnd.next = current;
        return head ;

    }
}