import util.ListNode;
import util.Util;

public class LinkedList021_mergeTwoLists_iteration {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 == null) {
            curr.next = l2;
        } else if (l2 == null) {
            curr.next = l1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList021_mergeTwoLists_iteration().mergeTwoLists(Util.arr2listNode(1, 2, 4), Util.arr2listNode(1, 3, 4));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}