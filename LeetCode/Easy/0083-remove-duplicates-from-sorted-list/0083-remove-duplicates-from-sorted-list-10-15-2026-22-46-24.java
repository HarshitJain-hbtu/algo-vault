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
        // M-1 brut force  | time O(n) | space o(n)
        if (node == null){
            return node;
        }
        Set<Integer> set = new LinkedHashSet<>();
        ListNode temp = node;
        while (temp != null){
            set.add(temp.val);
            temp = temp.next;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        for (int val : set){
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummyHead.next;
    }
    // we cannot directly print the linked list by sout 
    // when we return the head node that represent the linked list it will automatic traverse entire    
    // linked list and act like we return whole linked list 
    // we can access the whole ll if its class is defined 
}