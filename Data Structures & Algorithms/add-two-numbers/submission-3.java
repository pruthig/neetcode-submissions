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
        int carry = 0;
        ListNode fakeHead = new ListNode(-1);
        ListNode dummy = fakeHead;
        while(l1 != null || l2 != null || carry > 0) {
            int total = ((l1!=null)?l1.val:0) + ((l2!=null)?l2.val:0) + carry;
            dummy.next = new ListNode(total%10);
            dummy = dummy.next;
            carry = total/10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return fakeHead.next;
        
    }
}
