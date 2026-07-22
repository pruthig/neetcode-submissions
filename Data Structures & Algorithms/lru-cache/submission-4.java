class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int k, int v, Node p, Node n) {
        key = k;
        val = v;
        next = n;
        prev = p;
    }
}
class LRUCache {
    Map<Integer, Node> map = null;
    Node dhead = null, dtail = null;
    int maxSize;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        dhead = new Node(0, 0, null, null);
        dtail = new Node(0, 0, null, null);
        dhead.next = dtail;
        dtail.prev = dhead;
        maxSize = capacity;
    }
    
    public void removeNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = null;
        n.prev = null;
    }
    public void addHead(Node n) {
        Node oldHead = dhead.next;
        n.next = oldHead;
        oldHead.prev = n;
        n.prev = dhead;
        dhead.next = n;
    }
    public int get(int key) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            removeNode(n);
            addHead(n);
            return map.get(key).val;
        }
        else
            return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            removeNode(n);
            n.val = value;
            addHead(n);
            map.put(key, n);
        } else {
            Node nw = new Node(key, value, null, null);
            addHead(nw);
            map.put(key, nw);
            if(map.size()>maxSize) {
                Node last = dtail.prev;
                removeNode(last);
                map.remove(last.key);
            }
        }
    }
}
