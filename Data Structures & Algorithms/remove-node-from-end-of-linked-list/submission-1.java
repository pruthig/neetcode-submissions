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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        for(int i=0;i<n;++i) {
            cur = cur.next;
        }
        ListNode ds = dummy;
        while(cur.next != null) {
            ds = ds.next;
            cur = cur.next;
        }
        ds.next = ds.next.next;
        return dummy.next;
    }
}
