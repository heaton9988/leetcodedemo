import util.ListNode;
import util.Util;

public class LinkedList061_rotateRight {
    public ListNode rotateRight(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;
        ListNode tail = null;
        while (curr != null) {
            if (curr.next == null) {
                tail = curr;
            }
            n++;
            curr = curr.next;
        }
        k = k % n;
        if (k == 0) return head;

        ListNode nextHead = head;
        ListNode pre = null;
        for (int i = 1; i <= k; i++) {
            pre = nextHead;
            nextHead = nextHead.next;
        }
        tail.next = head;
        pre.next = null;

        return nextHead;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList061_rotateRight().rotateRight(Util.arr2listNode(1, 2, 3, 4, 5), 2);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}