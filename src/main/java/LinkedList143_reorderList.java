import util.ListNode;
import util.Util;

public class LinkedList143_reorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode leftEnd = leftEnd(head);
        ListNode currRight = reverseSecond(leftEnd);
        leftEnd.next = null;
        ListNode currLeft = head;
        ListNode tail = null;

        while (currRight != null) {
            ListNode nextLeft = currLeft.next;
            ListNode nextRight = currRight.next;

            currLeft.next = currRight;
            currRight.next = nextLeft;

            currLeft = nextLeft;
            currRight = nextRight;
            if (currLeft != null && currRight != null) {
                tail = currRight;
            } else if (currRight == null && currLeft != null) {
                tail = currLeft;
            }
        }
        if (tail != null) tail.next = null;
    }

    private ListNode leftEnd(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseSecond(ListNode leftEnd) {
        ListNode curr = leftEnd.next;
        ListNode pre = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            leftEnd.next = curr;
            pre = curr;
            curr = temp;
        }
        return leftEnd.next;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = Util.arr2listNode(1, 2, 3, 4,5);
        new LinkedList143_reorderList().reorderList(listNode);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}