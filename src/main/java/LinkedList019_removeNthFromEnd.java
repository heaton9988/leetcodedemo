import util.ListNode;
import util.Util;

public class LinkedList019_removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList019_removeNthFromEnd().removeNthFromEnd(Util.arr2listNode(1, 2), 2);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}