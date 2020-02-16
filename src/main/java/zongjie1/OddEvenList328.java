package zongjie1;

import util.ListNode;
import util.Util;

// dummy 1  2  3  4 5
public class OddEvenList328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Object o = new OddEvenList328().oddEvenList(Util.arr2listNode(new int[]{2, 1, 3, 5, 6, 4, 7}));
        Util.printListNode(o);
    }
}
