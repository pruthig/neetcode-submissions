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
        Node d = head;
        Node newH = null;
        while(d != null) {
            Node n = new Node(d.val);
            if(newH == null)
                newH = n;
            map.put(d, n);
            d = d.next;
        }
        d = head;
        while(d != null) {
            map.get(d).next = map.get(d.next);
            map.get(d).random = map.get(d.random);
            d = d.next;
        }
        return newH;
    }
}
