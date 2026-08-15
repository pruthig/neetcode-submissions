class Node {
    public int key;
    public int val;
    public Node next;
    public Node prev;
    public Node(int key, int val) {
        this.val = val;
        this.key = key;
        next = null;
        prev = null;
    }
}

class LRUCache {
    int mx = 0, cur = 0;
    Node head = null, tail = null;
    Map<Integer, Node> map = null;
    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        this.mx = capacity;
    }
    public void addNode(Node n) {
        Node oldHead = head.next;
        n.next = oldHead;
        n.prev = head;
        head.next = n;
        oldHead.prev = n;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            removeNode(n);
            addNode(n);
            return map.get(key).val;
        }
        else
            return -1;
    }
    public void removeNode(Node n) {
        if(head.next == tail)
            return;
        Node nPrev = n.prev;
        Node nNext = n.next;
        n.prev = null;
        n.next = null;
        nPrev.next = nNext;
        nNext.prev = nPrev;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            removeNode(n);
            n.val = value;
            addNode(n);
        } else {
            Node n = new Node(key, value);
            map.put(key, n);
            addNode(n);
            ++cur;
            if(cur > mx) {
                Node n1 = tail.prev;
                int k = n1.key;
                map.remove(k);
                removeNode(n1);
                --cur;
            }
        }
    }
}
