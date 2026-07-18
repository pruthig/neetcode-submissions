class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;
    public Node(int k, int v) {
        val = v;
        key = k;
        next = null;
        prev = null;
    }
}

class LRUCache {
    int mxSize = 0;
    int curSize = 0;
    Node dhead, dtail;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        mxSize = capacity;
        dhead = new Node(-1, -1);
        dtail = new Node(-1, -1);
        dhead.next = dtail;
        dtail.prev = dhead;
        map = new HashMap<>();
    }
    
    public void removeFromList(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = null;
        n.prev = null;
    }
    public void addToHead(Node n) {
        Node actualHead = dhead.next;
        n.next = actualHead;
        actualHead.prev = n;

        n.prev = dhead;
        dhead.next = n;
    }
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        Node n = map.get(key);
        removeFromList(n);
        addToHead(n);
        return n.val;
    }
    
    public void put(int key, int val) {
        if(!map.containsKey(key)) {
            Node n = new Node(key, val);
            map.put(key, n);
            addToHead(n);
            ++curSize;
        } else {
            Node n = map.get(key);
            n.val = val;
            map.put(key, n);
            removeFromList(n);
            addToHead(n);
        }
        if(curSize > mxSize) {
            int temp = dtail.prev.key;
            removeFromList(dtail.prev);
            map.remove(temp);
            --curSize;
        }
    }
}
