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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // M-3  optimal approach | time O(n) and space O(1)  in single traversal 
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        // Move fast n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast.next == null) return head;
            fast = fast.next;
        }

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Delete the target node
        slow.next = slow.next.next;

        return dummy.next;
    }
}