import util.ListNode;
import util.Util;

public class LinkedList147_insertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode tail = head, curr = head.next;
        while (curr != null) {
            if (curr.val >= tail.val) {
                tail = curr;
                curr = curr.next;
            } else {
                ListNode pre = dummy;
                while (pre != null && pre.next != null && curr.val > pre.next.val) {
                    pre = pre.next;
                }
                ListNode temp = curr.next;
                tail.next = temp;
                curr.next = pre.next;
                pre.next = curr;
                curr = temp;
            }
        }
        tail.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        ListNode listNode = new LinkedList147_insertionSortList().insertionSortList(Util.arr2listNode(-1, 5, 3, 4, 0,-1));
        ListNode listNode = new LinkedList147_insertionSortList().insertionSortList(Util.arr2listNode(4, 2, 1, 3));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}