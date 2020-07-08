import util.ListNode;
import util.Util;

public class LinkedList021_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null || l2 != null) {
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curr.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    curr.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                curr = curr.next;
            }
            while (l1 != null) {
                curr.next = new ListNode(l1.val);
                l1 = l1.next;
                curr = curr.next;
            }
            while (l2 != null) {
                curr.next = new ListNode(l2.val);
                l2 = l2.next;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList021_mergeTwoLists().mergeTwoLists(Util.arr2listNode(1, 2, 4), Util.arr2listNode(1, 3, 4));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}