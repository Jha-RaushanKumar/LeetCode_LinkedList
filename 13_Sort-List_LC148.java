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
    public ListNode sortList(ListNode head) {

        //Approach1 -- TC:O(N*logN) SC:O(N)
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = head;
        dummy = middleNode(dummy);
        ListNode dummy2 = dummy.next;
        dummy.next = null;

        ListNode part1 = sortList(head);
        ListNode part2 = sortList(dummy2);

        head = mergeTwoLists(part1,part2);
        return head;
        
    }

    public ListNode middleNode(ListNode head) {

        //Approach1 -- TC:O(N) SC:O(1)
        ListNode slow  = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
        
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode newnode = new ListNode (-1);
        ListNode head = newnode;
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                ListNode n = new ListNode (list1.val);
                newnode.next = n;
                list1 = list1.next;
            }
            else{
                ListNode n = new ListNode (list2.val);
                newnode.next = n;
                list2 = list2.next;
            }
            newnode = newnode.next;
        }
        if(list1 != null){
            newnode.next = list1;
        }
        if(list2 != null){
            newnode.next = list2;
        }
        return head.next;
        
    }
}