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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // optimal approch | time O(n) | space O(1)
        ListNode dummyhead = new ListNode();
        ListNode node = dummyhead;

        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                node.next = list1;
                list1 = list1.next;
                node = node.next;
            }
            else {
                node.next = list2;
                list2 = list2.next;
                node = node.next;
            }
        }
        // if one is completely traversed and one is remaining 
        if (list1 != null){
            node.next = list1;
        }
        else if (list2 != null){
            node.next = list2;
        }
        return dummyhead.next ;
    }
}