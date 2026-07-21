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
            return head;
        ListNode temp = head;
        int i=0;
        while(temp.next != null && i<n) {
            temp = temp.next;
            ++i;
        }
        if(temp == head)
            return null;
        if(i<n)
            return head.next;
        ListNode temp2 = head;
        while(temp.next != null) {
            temp = temp.next;
            temp2 = temp2.next;
        }
        temp2.next = temp2.next.next;
        return head;
    }
}
