import util.ListNode;
import util.Util;

public class LinkedList082_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;
        Integer v = null;
        while (curr != null && curr.next != null) {
            if ((v != null && v.equals(curr.next.val)) || (curr.next.next != null && curr.next.val == curr.next.next.val)) {
                v = curr.next.val;
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList082_deleteDuplicates().deleteDuplicates(Util.arr2listNode(1, 2, 3, 3, 4, 4, 5));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}