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
    ListNode mergeList(ListNode first, ListNode second) {
        if(first == null)
            return second;
        if(second == null)
            return first;
        if(first.val <= second.val) {
            first.next = mergeList(first.next, second);
            return first;
        } else {
            second.next = mergeList(first, second.next);
            return second;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        int len = lists.length;
        for(int i=len-1; i>=1; i /= 2) {
            for(int j=0;j<=i/2;++j) {
                if(j == (i-j))
                    continue;
                lists[j] = mergeList(lists[j], lists[i-j]);
            }
        }
        return lists[0];
    }
}
