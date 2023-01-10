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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return head;
        }

        //Approach1 -- TC:O(N) SC:O(1)
        ListNode temp = head;
        int len = 1;
        while(temp.next != null){
            temp = temp.next;
            len++;
        }

        temp.next = head;
        k = k%len;
        int i = 0;
        while(i<len-k){
            temp = temp.next;
            i++;
        }
        head = temp.next;
        temp.next = null;

        return head;
        
    }
}