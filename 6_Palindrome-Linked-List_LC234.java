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
    public boolean isPalindrome(ListNode head) {

        //Approach1 -- TC:O(N) SC:O(1)
        ListNode mid = middleNode(head);
        mid = reverseList(mid);

        while(mid != null){
            if(head.val != mid.val){
                return false;
            }
            mid = mid.next;
            head = head.next;
        }
        return true;
        
    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        return prev;
        
    }

    public ListNode middleNode(ListNode head) {

        ListNode slow  = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }
}