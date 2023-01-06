/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //Approach1 -- TC:O(N) SC:O(N)
        HashSet<ListNode> hm = new HashSet<>();
        while(headA != null){
            hm.add(headA);
            headA = headA.next;
        }

        while(headB != null){
            if(hm.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}