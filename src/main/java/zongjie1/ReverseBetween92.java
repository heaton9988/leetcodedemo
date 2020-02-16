package zongjie1;

import util.ListNode;
import util.Util;

// 1 2 3 4
// 1->null   pre=1 curr=2
// 2->1->null
public class ReverseBetween92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
            curr = curr.next;
        }

        for (int i = 0; i < n - m; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;

            temp.next = pre.next;
            pre.next = temp;

            Util.printListNode(dummy.next);

//            pre.next = temp;
//            temp.next = curr;
//
//            curr = temp;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Object o = new ReverseBetween92().reverseBetween(Util.arr2listNode(new int[]{1, 2, 3, 4, 5}), 2, 4);
        Util.printListNode(o);
    }
}
