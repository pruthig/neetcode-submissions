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
        Map<Node, Node> map = new HashMap<>();
        Node temp = head, nHead = null;
        while(temp != null) {
            Node n = new Node(temp.val);
            if(nHead == null)
                nHead = n;
            map.put(temp, n);
            temp = temp.next;
        }
        temp = head;
        while(temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return nHead;
        
    }
}
