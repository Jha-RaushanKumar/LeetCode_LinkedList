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
        
        //Approach1 -- TC:O(N) SC:O(N)

        l1 = reverse(l1);
        l2 = reverse(l2);

        int carry = 0;
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;

        while(l1 != null && l2 != null){
            int sum = l1.val+l2.val+carry;

            carry = sum/10;
            sum = sum%10;
            ListNode s = new ListNode(sum);
            ans.next = s;
            l1 = l1.next;
            l2 = l2.next;
            ans = ans.next;
        }
        while(l1 != null){
            int sum = l1.val+carry;

            carry = sum/10;
            sum = sum%10;

            ListNode s = new ListNode(sum);
            ans.next = s;
            l1 = l1.next;
            ans = ans.next;
        }
        while(l2 != null){
            int sum = l2.val+carry;

            carry = sum/10;
            sum = sum%10;

            ListNode s = new ListNode(sum);
            ans.next = s;
            l2 = l2.next;
            ans = ans.next;
        }
        if(carry >0){
            ListNode s = new ListNode(carry);
            ans.next = s;
        }
        return reverse(dummy.next);
        
    }

    public static ListNode reverse(ListNode head){

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;


        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
}