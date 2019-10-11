import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node newHead = new Node(head.val, head.next, head.random);
        Node currNode = newHead;

        HashMap<Integer, Node> val2node = new HashMap<>();

        val2node.put(newHead.val, newHead);
        while (currNode.next != null) {
            Node cacheNodeNext = val2node.get(currNode.next.val);
            if (cacheNodeNext == null) {
                cacheNodeNext = new Node(currNode.next.val, currNode.next.next, currNode.next.random);
                val2node.put(cacheNodeNext.val, cacheNodeNext);
            }
            currNode.next = cacheNodeNext;

            if (currNode.random != null) {
                Node cacheNodeRandom = val2node.get(currNode.random.val);
                if (cacheNodeRandom == null) {
                    cacheNodeRandom = new Node(currNode.random.val, currNode.random.next, currNode.random.random);
                    val2node.put(cacheNodeRandom.val, cacheNodeRandom);
                }
                currNode.random = cacheNodeRandom;
            }

            currNode = currNode.next;
        }
        if (currNode.random != null) {
            Node cacheNodeRandom = val2node.get(currNode.random.val);
            if (cacheNodeRandom == null) {
                cacheNodeRandom = new Node(currNode.random.val, currNode.random.next, currNode.random.random);
            }
            currNode.random = cacheNodeRandom;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Random r = new Random();
        Node head = null;
        int total = 5;
        HashMap<Integer, Node> index2node = new HashMap<>();
        for (int i = 0; i < total; i++) {
            Node n = new Node();
            n.val = i;
            index2node.put(i, n);
            if (i == 0) {
                head = n;
            }
        }
        for (Map.Entry<Integer, Node> entry : index2node.entrySet()) {
            int index = entry.getKey();
            Node currNode = entry.getValue();

            currNode.random = index2node.get(r.nextInt(5));
            if (index != total - 1) {
                currNode.next = index2node.get(index + 1);
            }
        }

        long start = System.currentTimeMillis();
        Node result = new CopyRandomList().copyRandomList(head);
        System.out.println(result);

        System.out.println(System.currentTimeMillis() - start + " ms");
    }

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    ;
}