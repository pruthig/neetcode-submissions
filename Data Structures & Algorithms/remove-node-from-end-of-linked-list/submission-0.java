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
        if(head == null)
            return null;
        ListNode base = head;
        int i=0;
        while(i<n && base != null) {
            ++i;
            base = base.next;
        }
        if(base == null)
            return head.next;
        ListNode second = head;
        while(base.next != null) {
            second = second.next;
            base = base.next;
        }

        second.next = second.next.next;
        return head;
    }
}
