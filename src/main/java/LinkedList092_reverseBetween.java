import util.ListNode;
import util.Util;

public class LinkedList092_reverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode h = pre.next, t = h;
        for (int i = m; i < n; i++) {
            ListNode nextHead = t.next;
            ListNode nextStart = nextHead.next;
            nextHead.next = h;
            pre.next = nextHead;
            t.next = nextStart;
            h = nextHead;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        Object obj = new LinkedList092_reverseBetween().reverseBetween(Util.arr2listNode(1, 2, 3, 4, 5, 6), 2, 4);
        Object obj = new LinkedList092_reverseBetween().reverseBetween(Util.arr2listNode(1, 2), 1, 2);
        System.out.println(obj);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}