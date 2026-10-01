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
        // brut force (using extra arrList) | time O(n) | space O(n) 
        List<Integer> list = new ArrayList<>();

        ListNode temp = head;
        while (temp != null){
            list.add(temp.val);
            temp = temp.next;
        }

        temp = head;
        // overwrite the linkedlist in reverse order and modify values
        for (int i = list.size() - 1;i >= 0; i--){
            temp.val = list.get(i);
            temp = temp.next;
        }
        return head;
    }
}