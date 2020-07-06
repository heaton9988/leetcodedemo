import util.ListNode;
import util.Util;

public class LinkedList369_plusOne {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy);
        if (dummy.val == 0) {
            return dummy.next;
        } else {
            return dummy;
        }
    }

    private int helper(ListNode node) {
        if (node.next == null) {
            if (node.val < 9) {
                node.val = node.val + 1;
                return 0;
            } else {
                node.val = 0;
                return 1;
            }
        } else {
            int add = helper(node.next);
            if (add == 0) return 0;
            if (node.val < 9) {
                node.val = node.val + 1;
                return 0;
            } else {
                node.val = 0;
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = new LinkedList369_plusOne().plusOne(Util.arr2listNode(9, 9, 9));
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}