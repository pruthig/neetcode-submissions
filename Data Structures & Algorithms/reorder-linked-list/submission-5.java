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
    public ListNode reverse(ListNode node) {
        if(node.next == null)
            return node;
        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
    public ListNode reorderListHelper(ListNode first, ListNode second, boolean flag) {
        if(first == null)
            return second;
        if(second == null)
            return first;
        if(flag) {
            first.next = reorderListHelper(first.next, second, !flag);
            return first;
        } else {
            second.next = reorderListHelper(first, second.next, !flag);
            return second;
        }
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;            
        }
        
        ListNode second = slow.next;
        slow.next = null;
        ListNode revSecond = reverse(second);
        ListNode f = reorderListHelper(head, revSecond, true);
    }
}
