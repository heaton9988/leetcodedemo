import util.ListNode;
import util.Util;

public class LinkedList148_sortList_top2bottom {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(secondHead);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList148_sortList_top2bottom().sortList(Util.arr2listNode(3, 2, 1));
        System.out.println(listNode);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}