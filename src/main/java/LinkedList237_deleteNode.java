import util.ListNode;
import util.Util;

public class LinkedList237_deleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new LinkedList237_deleteNode().deleteNode(Util.arr2listNode(1, 2));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}