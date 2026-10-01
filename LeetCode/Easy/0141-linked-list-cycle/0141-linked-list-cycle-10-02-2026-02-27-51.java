/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // better appraoch | time O(n) | space O(n)
        Set<ListNode> hasVisited = new HashSet<>();

        ListNode curr = head;
        while(curr != null){
            if(hasVisited.contains(curr)){
                return true;
            }

            hasVisited.add(curr);
            curr = curr.next;
        }
        return false;
    }
}