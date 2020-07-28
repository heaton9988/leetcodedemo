import java.util.*;

public class Random138_copyRandomList {
    Map<Node, Node> pre2copy = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node copy = pre2copy.get(head);
        if (copy == null) {
            copy = new Node(head.val);
            pre2copy.put(head, copy);
        }
        copy.next = copyRandomList(head.next);
        copy.random = copyRandomList(head.random);
        return copy;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Random138_copyRandomList randomSet = new Random138_copyRandomList();
        System.out.println(System.currentTimeMillis() - start + " ms");
    }

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
}