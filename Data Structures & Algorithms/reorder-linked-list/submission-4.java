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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode s = head, f = head.next;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode nHead = s.next;
        s.next = null;
        ListNode prev = null, cur = nHead, next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // prev is new head.. now merge
        ListNode second = prev;
        ListNode first = head;
        ListNode tmp1, tmp2;

        while(first != null && second != null) {
             tmp1 = first.next;
             tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
        // if(first == null)
        //     second.next = first;
        // else
        //     first.next = second;
        
    }
}
