import util.ListNode;
import util.Util;

public class LinkedList024_swapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode nextStart = next.next;

        next.next = head;
        head.next = swapPairs(nextStart);
        return next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Object obj = new LinkedList024_swapPairs().swapPairs(Util.arr2listNode(1, 2, 3, 4, 5));
        System.out.println(obj);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}