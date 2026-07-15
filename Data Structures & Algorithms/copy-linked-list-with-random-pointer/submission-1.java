/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        Node newHead = null;
        while(cur != null) {
            Node n = new Node(cur.val);
            if(newHead == null)
                newHead = n;
            map.put(cur, n);
            cur = cur.next;
        }
        // correct all pointers
        cur = head;
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return newHead;
    }
}
