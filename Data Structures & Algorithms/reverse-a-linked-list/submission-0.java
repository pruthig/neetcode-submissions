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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null, cur = head, next = null;
        while(cur != null) {
            next = cur.next; // X
            cur.next = prev; // 3->2
            prev = cur; // 3
            cur = next; // X
        }
        return prev;
    }
}
