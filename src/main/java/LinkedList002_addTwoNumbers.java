import util.ListNode;
import util.Util;

public class LinkedList002_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int n1 = l1.val, n2 = l2.val;
        int last = 0;

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null || l2 != null) {
            int val = n1 + n2 + last;
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            last = val < 10 ? 0 : 1;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            n1 = (l1 == null) ? 0 : l1.val;
            n2 = (l2 == null) ? 0 : l2.val;
        }
        if (last == 1) {
            curr.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList002_addTwoNumbers().addTwoNumbers(Util.arr2listNode(2, 4, 3), Util.arr2listNode(5, 6, 7));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}