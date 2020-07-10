/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

public class Day10 {
    private static final class List {
        public Node head;
        public Node tail;

        public List() {}

        public List(Node head, Node tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public Node flatten(Node head) {
        List list = buildList(head);
        return list.head;
    }

    private List buildList(Node node) {
        if (node == null) {
            return new List();
        }

        Node curr = node;

        while (curr.next != null || curr.child != null) {
            if (curr.child != null) {
                List child_list = buildList(curr.child);
                curr.child = null;
                Node after_list = curr.next;

                curr.next = child_list.head;
                child_list.head.prev = curr;

                child_list.tail.next = after_list;
                if (after_list != null) {
                    after_list.prev = child_list.tail;
                }

                curr = child_list.tail;
            }

            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }

        return new List(node, curr);
    }
}
