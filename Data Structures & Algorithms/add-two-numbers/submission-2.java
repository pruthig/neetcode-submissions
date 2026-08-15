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
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode d1 = l1;
        ListNode d2 = l2;
        int carry = 0;
        ListNode fakeHead = new ListNode(-1);
        ListNode dummy = fakeHead;
        while(d1 != null || d2 != null || carry > 0) {
            int total = ((d1!=null)?d1.val:0) + ((d2!=null)?d2.val:0) + carry;
            dummy.next = new ListNode(total%10);
            dummy = dummy.next;
            carry = total/10;
            if(d1 != null) d1 = d1.next;
            if(d2 != null) d2 = d2.next;
        }
        return fakeHead.next;
        
    }
}
