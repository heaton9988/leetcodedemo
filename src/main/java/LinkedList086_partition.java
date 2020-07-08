import util.ListNode;
import util.Util;

public class LinkedList086_partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode firstBigger = head;
        while (firstBigger != null && firstBigger.val < x) {
            firstBigger = firstBigger.next;
            pre = pre.next;
        }
        ListNode curr = firstBigger;
        ListNode currPre = pre;
        while (curr != null) {
            if (curr.val < x) {
                currPre.next = curr.next;
                pre.next = curr;
                curr.next = firstBigger;
                pre = curr;
                curr = currPre.next;
            } else {
                currPre = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList086_partition().partition(Util.arr2listNode(1, 4, 3, 2, 5, 1), 3);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}