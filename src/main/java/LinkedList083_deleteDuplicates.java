import util.ListNode;
import util.Util;

public class LinkedList083_deleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.next.val == curr.val) {
                curr.next = curr.next.next;
                continue;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList083_deleteDuplicates().deleteDuplicates(Util.arr2listNode(1, 1, 2, 2));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}