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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = null, oldNode = null;
        int carry = 0;
        while(l1 != null || l2 != null || carry > 0) {
            int s1 = (l1==null)?0:l1.val;
            int s2 = (l2==null)?0:l2.val;
            int sum = s1 + s2 + carry;
            ListNode x = new ListNode(sum%10);
            carry = sum/10;
            if(newNode == null) 
                newNode = x;
            if(oldNode != null) {
                oldNode.next = x;
                oldNode = x;
            } else {
                oldNode = x;
            }
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        return newNode;
    }
}
