import util.ListNode;
import util.Util;

public class LinkedList142_detectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow)break;
        }
        if(fast == null || fast.next == null) return null;
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

//
//        if (head == null || head.next == null) return null;
//        ListNode slow = head;
//        ListNode fast = head;
//        do {
//            if (fast.next == null || fast.next.next == null) return null;
//            slow = slow.next;
//            fast = fast.next.next;
//        } while (slow != fast);
//        fast = head;
//        while (slow != fast) {
//            slow = slow.next;
//            fast = fast.next;
//        }
//        return slow;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ListNode listNode = Util.buildCycliclistNode(new Integer[]{1, 2, 3, 4}, 1, 3);
        ListNode listNode1 = new LinkedList142_detectCycle().detectCycle(listNode);
        System.out.println(System.currentTimeMillis() - start + " ms");
    }
}