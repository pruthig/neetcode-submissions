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
    ListNode mergeLists(ListNode l1, ListNode l2, boolean flag) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(flag) {
            l1.next = mergeLists(l1.next, l2, !flag);
            return l1;
        } else {
            l2.next = mergeLists(l1, l2.next, !flag);
            return l2;
        }

    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // now slow points to middle
        ListNode newHead = slow.next;
        slow.next = null;
        // reverse
        ListNode prev = null, cur = newHead, next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // now prev has 2nd head;
        ListNode first = head, second = prev;
        ListNode mlHead = mergeLists(head, prev, true);
        head = mlHead;
    }
}
