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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // M-2  optimal (not creation arr and in single pass) | time O(n) | auxilary space O(1)
        
        // creating new LL after adding nodes val in rev order
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        int carry = 0;
        
        // Loop continues as long as there is a node in l1, OR l2, OR a leftover carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the carry from the previous step
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;           // Extract the tens place
            int val = sum % 10;         // Extract the ones place
            
            node.next = new ListNode(val);
            node = node.next;
        }
        
        return dummy.next;
    }
}