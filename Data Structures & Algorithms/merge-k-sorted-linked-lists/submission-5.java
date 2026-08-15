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
    public ListNode mergeList(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val <= l2.val) {
            l1.next = mergeList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeList(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        int k = lists.length-1;
        for(int i=k;i>0;i=i/2) {
            for(int j=0;j<=i/2;++j) {
                if((i-j)==j)
                    continue;
                lists[j] = mergeList(lists[j], lists[i-j]);
            }
        }
        return lists[0];
    }
}
