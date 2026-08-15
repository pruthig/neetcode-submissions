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
        ListNode dummy = new ListNode(-1, head);
        int cur = 0;
        ListNode d = dummy;
        while(d != null && cur<n) {
            d = d.next;
            cur++;
        }
        if(d == null)
            return null;
        ListNode starter = dummy;
        while(d.next != null) {
            starter = starter.next;
            d = d.next;
        }
        starter.next = starter.next.next;
        return dummy.next;
    }
}
