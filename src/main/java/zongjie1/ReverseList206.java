package zongjie1;

import util.ListNode;
import util.Util;

// 1 2 3 4
// 1->null   pre=1 curr=2
// 2->1->null
public class ReverseList206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;

            curr.next = pre;
            pre = curr;

            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Object o = new ReverseList206().reverseList(Util.arr2listNode(new int[]{1, 2, 3, 4}));
        Util.printListNode(o);
    }
}
