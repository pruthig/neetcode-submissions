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
    public ListNode reverseListHelper(ListNode prev, ListNode head) {
        if(head.next == null) {
            head.next = prev;
            return head;
        }
        ListNode nxt = head.next;
        head.next = prev;
        return reverseListHelper(head, nxt);
    }
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        return reverseListHelper(null, head);
    }
}
