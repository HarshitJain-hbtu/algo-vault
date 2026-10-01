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
        // M-2  brut force | time O(n) and space O(n)  but in single traversal 
        List<ListNode> nodes = new ArrayList<>();

        for (ListNode curr = head; curr != null; curr = curr.next) {
            nodes.add(curr);
        }

        int index = nodes.size() - n;

        if (index < 0 || n <= 0) return head;

        if (index == 0) {
            return head.next;
        }

        nodes.get(index - 1).next = nodes.get(index).next;
        return head;
    }
}