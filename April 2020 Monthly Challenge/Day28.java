import java.util.*;

public class Day28 {
    private static final class Node {
        public Node next;
        public Node prev;
        public int val;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private HashMap<Integer, Node> nodes = new HashMap<>();
    private HashSet<Integer> blacklist = new HashSet<>();

    public FirstUnique(int[] nums) {
        for (int num : nums) {
            add(num);
        }
    }

    public int showFirstUnique() {
        return head == null ? -1 : head.val;
    }

    public void remove(Node node) {
        nodes.remove(node.val);
        blacklist.add(node.val);

        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    public void add(int value) {
        if (blacklist.contains(value)) {
            return;
        }
        
        Node node = nodes.getOrDefault(value, null);
        if (node != null) {
            remove(node);
            return;
        }

        node = new Node(value);
        nodes.put(value, node);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
}
