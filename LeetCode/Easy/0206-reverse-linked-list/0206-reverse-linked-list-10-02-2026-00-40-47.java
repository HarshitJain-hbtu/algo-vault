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
    public ListNode reverseList(ListNode head) {
        // better approach  (using stack) | time O(n) | space O(n) 
        Stack<Integer> stack = new Stack<>();

        ListNode temp = head;
        while (temp != null){
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        // overwrite the linkedlist in reverse order
        while (!stack.isEmpty()){
            temp.val = stack.pop();
            temp = temp.next;
        }
        return head;
    }
}