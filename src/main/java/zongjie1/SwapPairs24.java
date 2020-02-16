package zongjie1;

import util.ListNode;
import util.Util;

// dummy 1  2  3  4
// l1    l2
// dummy 2  1  3  4
// l1       l2
// dummy 2  1  3
// l1       l1 l2
public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = dummy.next;
        while (l1 != null && l1.next != null && l1.next.next != null) {
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l1.next.next = l2;
            l1.next.next.next = nextStart;

            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        Object o = new SwapPairs24().swapPairs(Util.arr2listNode(new int[]{1}));
        printListNode(o);
        o = new SwapPairs24().swapPairs(Util.arr2listNode(new int[]{1, 2}));
        printListNode(o);
        o = new SwapPairs24().swapPairs(Util.arr2listNode(new int[]{1, 2, 3}));
        printListNode(o);
        o = new SwapPairs24().swapPairs(Util.arr2listNode(new int[]{1, 2, 3, 4}));
        printListNode(o);
    }

    public static void printListNode(Object o) {
        ListNode node = (ListNode) o;
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(",");
            node = node.next;
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 1);
        System.out.println("[" + sb.toString() + "]");
    }
}
