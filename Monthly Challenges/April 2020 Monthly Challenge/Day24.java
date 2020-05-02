public class Day24 {
    private static class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = null;
        tail = null;
    }

    public void removeNode(int key) {
        Node node = cache.getOrDefault(key, null);
        if (node == null) {
            return;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node == head) {
            head = node.next;
        }

        if (node == tail) {
            tail = node.prev;
        }

        cache.remove(key);
    }

    public void addNode(int key, int value) {
        Node node = new Node(key, value);

        if (head == null || tail == null) {
            head = node;
            tail = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }

        cache.put(key, node);

        if (cache.size() > capacity) {
            cache.remove(tail.key);
            if (tail.prev != null) {
                tail.prev.next = null;
            }
            tail = tail.prev;
        }
    }

    public int get(int key) {
        Node node = cache.getOrDefault(key, null);
        if (node == null) {
            return -1;
        }

        removeNode(key);
        addNode(node.key, node.val);

        return node.val;
    }

    public void put(int key, int value) {
        removeNode(key);
        addNode(key, value);
    }
}
