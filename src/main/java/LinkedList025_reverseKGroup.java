import util.ListNode;
import util.Util;

public class LinkedList025_reverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        for (int times = 1; times <= n / k; times++) {
            ListNode t = pre.next;
            ListNode h = t;
            for (int i = 1; i < k; i++) {
                ListNode nextStart = t.next.next;
                ListNode newHead = t.next;
                pre.next = newHead;
                t.next = nextStart;
                newHead.next = h;
                h = newHead;
            }
            pre = t;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList025_reverseKGroup().reverseKGroup(Util.arr2listNode(1, 2), 2);
        System.out.println(listNode);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}