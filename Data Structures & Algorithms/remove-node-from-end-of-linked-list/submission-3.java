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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy, temp2 = dummy;
        int i=0;
        while(temp.next != null && i<n) {
            temp = temp.next;
            ++i;
        }
        if(i<n)
            return dummy.next;
        while(temp.next != null) {
            temp = temp.next;
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        return dummy.next;
    }
}
