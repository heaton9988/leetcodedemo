import util.ListNode;
import util.Util;

public class LinkedList203_removeElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;
        while (curr != null && curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList203_removeElements().removeElements(Util.arr2listNode(1, 2, 3, 4, 5, 1), 1);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}