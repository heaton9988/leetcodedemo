import util.ListNode;
import util.Util;

public class LinkedList021_mergeTwoLists_recursion {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList021_mergeTwoLists_recursion().mergeTwoLists(Util.arr2listNode(1, 2, 4), Util.arr2listNode(1, 3, 4));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}